package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasPagarDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ContasPagarPrincipal;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author eknascimento
 */
public class ContasPagarController {

    private ContasPagarPrincipal viewContasPagar;
    private ContasPagar contasPagar = new ContasPagar();
    private Compra compra;

    public ContasPagarController() {
    }

    public ContasPagarController(ContasPagarPrincipal viewContasPagar) {
        this.viewContasPagar = viewContasPagar;
    }

    public void carregaCompra() {
        CompraController controllerCompra = new CompraController();
        this.compra = controllerCompra.retornaUltimaCompra();
    }

    public void carregaLabels() {
        carregaCompra();
        this.viewContasPagar.getJrbPagoNao().setSelected(true);
        this.viewContasPagar.getJrbNao().setSelected(true);
        this.viewContasPagar.getjLabel11().setText(this.compra.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        this.viewContasPagar.getjLabel12().setText(this.compra.getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome());
        this.viewContasPagar.getjLabel13().setText(Mensagem.real + this.compra.getValorTotal());
    }

    public void bloqueioInicial() {
        this.viewContasPagar.getJrbSim().setEnabled(false);
        this.viewContasPagar.getJrbNao().setEnabled(false);
        this.viewContasPagar.getJrbPagoSim().setEnabled(false);
        this.viewContasPagar.getJrbPagoNao().setEnabled(false);
        carregaLabels();
    }

    public boolean validaSalvar() {
        if (Valida.vazio(this.viewContasPagar.getJtfPagar().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasPagar.getJtfPagar().setValue(null);
            this.viewContasPagar.getJtfPagar().grabFocus();
            return false;
        }
        if (!Valida.dataValida(this.viewContasPagar.getJtfPagar().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasPagar.getJtfPagar().setValue(null);
            this.viewContasPagar.getJtfPagar().grabFocus();
            return false;
        }
        if (Valida.vazio(this.viewContasPagar.getJtfVencimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasPagar.getJtfVencimento().setValue(null);
            this.viewContasPagar.getJtfVencimento().grabFocus();
            return false;
        }
        if (!Valida.dataValida(this.viewContasPagar.getJtfVencimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasPagar.getJtfVencimento().setValue(null);
            this.viewContasPagar.getJtfVencimento().grabFocus();
            return false;
        }
        return true;
    }

    public void acaoBotaoSalvar() {
        if (validaSalvar()) {
            ContasPagarDAO dao = new ContasPagarDAO();

            contasPagar = new ContasPagar();
            contasPagar.setCompraIdCompra(compra);
            contasPagar.setDataPagamento(this.viewContasPagar.getJtfPagar().getText());
            contasPagar.setDataVencimento(this.viewContasPagar.getJtfVencimento().getText());
            contasPagar.setVencida(this.viewContasPagar.getJrbSim().isSelected() ? this.viewContasPagar.getJrbSim().getText() : this.viewContasPagar.getJrbNao().getText());
            contasPagar.setPagamento(this.viewContasPagar.getJrbPagoSim().isSelected() ? this.viewContasPagar.getJrbPagoSim().getText() : this.viewContasPagar.getJrbPagoNao().getText());

            compra = contasPagar.getCompraIdCompra();

            dao.salvar(contasPagar);
            LogUsuarioController controllerLogUsuario = new LogUsuarioController();
            Funcionario func1 = controllerLogUsuario.buscaFuncionario();
            salvarTimeStamp(func1, "SALVAR");
            JOptionPane.showMessageDialog(null, Mensagem.contasReceberPago);

            this.viewContasPagar.dispose();
        }
    }
    
    public void salvarTimeStamp(Funcionario funcionario, String operacao) {
        Calendar cal = Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        int horaAtual = cal.get(Calendar.HOUR);
        int minutoAtual = cal.get(Calendar.MINUTE);
        int segundoAtual = cal.get(Calendar.SECOND);
        int milissegundoAtual = cal.get(Calendar.MILLISECOND);

        String strData = anoAtual + "-" + mesAtual + "-" + diaAtual + " " + horaAtual + ":" + minutoAtual + ":" + segundoAtual + "." + milissegundoAtual;
        LogUsuario logUsuario = new LogUsuario();
        LogUsuarioController controllerLogUsuario = new LogUsuarioController();
        logUsuario.setFuncionarioIdFuncionario(funcionario);
        logUsuario.setOperacao(operacao);
        logUsuario.setTabela(Mensagem.contasPagar);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

    public void salvar(ContasPagar contasPagar) {
        ContasPagarDAO dao = new ContasPagarDAO();
        dao.salvar(contasPagar);
    }
}
