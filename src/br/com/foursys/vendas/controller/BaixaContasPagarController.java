package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasPagarDAO;
import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.BaixaContasPagarPrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class BaixaContasPagarController {

    ContasPagar contasPagar = new ContasPagar();

    private BaixaContasPagarPrincipal viewContasPagar;
    private ArrayList<ContasPagar> listaContasPagar;
    private ArrayList<ContasPagar> listaContasPagar2;

    public BaixaContasPagarController(BaixaContasPagarPrincipal viewContasPagar) {
        this.viewContasPagar = viewContasPagar;
    }

    public void listarContasPagar() {
        try {
            ContasPagarDAO dao = new ContasPagarDAO();
            listaContasPagar = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(BaixaContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        listaContasPagar2 = new ArrayList<ContasPagar>();
        DefaultTableModel modelo = (DefaultTableModel) this.viewContasPagar.getTabelaContasPagar().getModel();
        modelo.setRowCount(0);
        for (ContasPagar listaContaPagar : listaContasPagar) {
            if (listaContaPagar.getPagamento().equals(Mensagem.nao)) {
                modelo.addRow(new String[]{listaContaPagar.getCompraIdCompra().getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome(), listaContaPagar.getCompraIdCompra().getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), listaContaPagar.getCompraIdCompra().getIdCompra() + Mensagem.vazio, listaContaPagar.getCompraIdCompra().getValorTotal() + Mensagem.vazio, listaContaPagar.getDataVencimento()});
                listaContasPagar2.add(listaContaPagar);
            }
        }
    }

    public void confirmarPagamento() {
        if (this.viewContasPagar.getTabelaContasPagar().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaPagamento);
        } else {
            contasPagar = listaContasPagar.get(this.viewContasPagar.getTabelaContasPagar().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaPagamento, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ContasPagarDAO dao = new ContasPagarDAO();
                contasPagar.setPagamento(Mensagem.sim);
                dao.salvar(contasPagar);
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.alterar);

                listarContasPagar();
            }
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

        String strData = anoAtual + Mensagem.hifen + mesAtual + Mensagem.hifen + diaAtual + Mensagem.espaco + horaAtual + Mensagem.doisPontos + minutoAtual + Mensagem.doisPontos + segundoAtual + Mensagem.ponto + milissegundoAtual;
        LogUsuario logUsuario = new LogUsuario();
        LogUsuarioController controllerLogUsuario = new LogUsuarioController();
        logUsuario.setFuncionarioIdFuncionario(funcionario);
        logUsuario.setOperacao(operacao);
        logUsuario.setTabela(Mensagem.contasPagar);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
