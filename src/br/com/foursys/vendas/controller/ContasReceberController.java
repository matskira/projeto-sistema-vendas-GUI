package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasReceberDAO;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ContasReceberPrincipal;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ContasReceberController {

    private ContasReceberPrincipal viewContasReceber;
    private ContasReceber contasReceber = new ContasReceber();
    private Venda venda;

    public ContasReceberController() {

    }

    public ContasReceberController(ContasReceberPrincipal viewContasReceber) {
        this.viewContasReceber = viewContasReceber;
    }

    public void carregaVenda() {
        VendaController controllerVenda = new VendaController();
        this.venda = controllerVenda.retornaUltimaVenda();
    }

    public void carregaLabels() {
        carregaVenda();
        this.viewContasReceber.getJrbPagoNao().setSelected(true);
        this.viewContasReceber.getJrbNao().setSelected(true);
        this.viewContasReceber.getJlbFuncionario().setText(this.venda.getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome());
        this.viewContasReceber.getJlbCliente().setText(this.venda.getClienteIdCliente().getTipoPessoa().equals(Mensagem.pessoaFisica) ? this.venda.getClienteIdCliente().getPessoaFisicaIdPessoaFisica().getNome() : this.venda.getClienteIdCliente().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        this.viewContasReceber.getJlbValorTotal().setText(Mensagem.real + this.venda.getValorTotal());
    }

    public void bloqueioInicial() {
        this.viewContasReceber.getJrbSim().setEnabled(false);
        this.viewContasReceber.getJrbNao().setEnabled(false);
        this.viewContasReceber.getJrbPagoSim().setEnabled(false);
        this.viewContasReceber.getJrbPagoNao().setEnabled(false);
        carregaLabels();
    }

    public boolean validaSalvar() {
        if (Valida.vazio(this.viewContasReceber.getJtfReceber().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataNascimento);
            this.viewContasReceber.getJtfReceber().setValue(null);
            this.viewContasReceber.getJtfReceber().grabFocus();
            return false;
        }
        if (!Valida.dataValida(this.viewContasReceber.getJtfReceber().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasReceber.getJtfReceber().setValue(null);
            this.viewContasReceber.getJtfReceber().grabFocus();
            return false;
        }
        if (Valida.vazio(this.viewContasReceber.getJtfVencimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasReceber.getJtfVencimento().setValue(null);
            this.viewContasReceber.getJtfVencimento().grabFocus();
            return false;
        }
        if (!Valida.dataValida(this.viewContasReceber.getJtfVencimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewContasReceber.getJtfVencimento().setValue(null);
            this.viewContasReceber.getJtfVencimento().grabFocus();
            return false;
        }
        return true;
    }

    public void acaoBotaoSalvar() {
        if (validaSalvar()) {
            ContasReceberDAO dao = new ContasReceberDAO();

            contasReceber = new ContasReceber();
            contasReceber.setVendaIdVenda(venda);
            contasReceber.setDataPagamento(this.viewContasReceber.getJtfReceber().getText());
            contasReceber.setDataVencimento(this.viewContasReceber.getJtfVencimento().getText());
            contasReceber.setVencida(this.viewContasReceber.getJrbSim().isSelected() ? this.viewContasReceber.getJrbSim().getText() : this.viewContasReceber.getJrbNao().getText());
            contasReceber.setPagamento(this.viewContasReceber.getJrbPagoSim().isSelected() ? this.viewContasReceber.getJrbPagoSim().getText() : this.viewContasReceber.getJrbPagoNao().getText());

            dao.salvar(contasReceber);

            JOptionPane.showMessageDialog(null, Mensagem.contasReceberPago);
            LogUsuarioController controllerLogUsuario = new LogUsuarioController();
            Funcionario func1 = controllerLogUsuario.buscaFuncionario();
            salvarTimeStamp(func1, "SALVAR");
            this.viewContasReceber.dispose();
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
        logUsuario.setTabela(Mensagem.contasReceber);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

    public void salvar(ContasReceber aReceber) {
        ContasReceberDAO dao = new ContasReceberDAO();
        dao.salvar(aReceber);
    }
}
