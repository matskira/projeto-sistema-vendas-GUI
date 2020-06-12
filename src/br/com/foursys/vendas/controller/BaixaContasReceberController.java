package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasReceberDAO;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.BaixaContasReceberPrincipal;
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
public class BaixaContasReceberController {

    ContasReceber contasReceber = new ContasReceber();
    private BaixaContasReceberPrincipal viewContasReceber;
    private ArrayList<ContasReceber> listaContasReceber;
    private ArrayList<ContasReceber> listaContasReceber2;

    public BaixaContasReceberController(BaixaContasReceberPrincipal viewContasReceber) {
        this.viewContasReceber = viewContasReceber;
    }

    public void listarContasReceber() {
        try {
            ContasReceberDAO dao = new ContasReceberDAO();
            listaContasReceber = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(BaixaContasReceberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        listaContasReceber2 = new ArrayList<ContasReceber>();
        DefaultTableModel modelo = (DefaultTableModel) this.viewContasReceber.getTabelaContasReceber().getModel();
        modelo.setRowCount(0);
        for (ContasReceber listaContaReceber : listaContasReceber) {
            if (listaContaReceber.getPagamento().equals(Mensagem.nao)) {
                modelo.addRow(new String[]{listaContaReceber.getVendaIdVenda().getClienteIdCliente().getPessoaFisicaIdPessoaFisica().getNome(), listaContaReceber.getVendaIdVenda().getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome(), listaContaReceber.getVendaIdVenda().getIdVenda() + "", listaContaReceber.getVendaIdVenda().getValorTotal() + "", listaContaReceber.getDataVencimento()});
                listaContasReceber2.add(listaContaReceber);
            }
        }
    }

    public void confirmarRecebimento() {
        if (this.viewContasReceber.getTabelaContasReceber().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaPagamento);
        } else {
            contasReceber = listaContasReceber2.get(this.viewContasReceber.getTabelaContasReceber().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaRecebimento, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ContasReceberDAO dao = new ContasReceberDAO();
                contasReceber.setPagamento(Mensagem.sim);
                dao.salvar(contasReceber);
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.alterar);
                listarContasReceber();
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

        String strData = anoAtual + "-" + mesAtual + "-" + diaAtual + " " + horaAtual + ":" + minutoAtual + ":" + segundoAtual + "." + milissegundoAtual;
        LogUsuario logUsuario = new LogUsuario();
        LogUsuarioController controllerLogUsuario = new LogUsuarioController();
        logUsuario.setFuncionarioIdFuncionario(funcionario);
        logUsuario.setOperacao(operacao);
        logUsuario.setTabela(Mensagem.contasReceber);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
