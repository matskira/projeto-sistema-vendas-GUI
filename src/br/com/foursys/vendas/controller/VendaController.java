package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.VendaDAO;
import br.com.foursys.vendas.model.Cliente;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.ItemVenda;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ContasReceberPrincipal;
import br.com.foursys.vendas.view.VendaPrincipal;
import java.text.DecimalFormat;
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
public class VendaController {

    private VendaPrincipal viewVenda;
    private Estoque estoque;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Estoque> listaEstoques;
    private ArrayList<Estoque> listaEstoques2;
    private ArrayList<Estoque> listaEstoques3;
    private double valorTotal;
    private String formaPagamento;

    public VendaController(VendaPrincipal viewVenda) {
        this.viewVenda = viewVenda;
    }

    public VendaController() {
    }

    public void carregarComboFuncionario() {
        FuncionarioController controller = new FuncionarioController();
        try {
            listaFuncionarios = controller.buscarFuncionarios();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewVenda.getJcbFuncionario().removeAllItems();
        this.viewVenda.getJcbFuncionario().addItem(Mensagem.comboFuncionario);
        for (Funcionario listaFuncionario : listaFuncionarios) {
            this.viewVenda.getJcbFuncionario().addItem(listaFuncionario.getPessoaFisicaIdPessoaFisica().getNome());
        }
    }

    public void carregarComboDescricao() {
        EstoqueController controller = new EstoqueController();
        listaEstoques3 = new ArrayList<Estoque>();
        try {
            listaEstoques = controller.buscarEstoques();
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Estoque> aux = new ArrayList<Estoque>();
        this.viewVenda.getJcbProduto().removeAllItems();
        this.viewVenda.getJcbProduto().addItem(Mensagem.comboProduto);
        for (Estoque listaEstoque : listaEstoques) {
            if (listaEstoque.getQuantidadeEstoque() > listaEstoque.getQuantidadeMinima()) {
                this.viewVenda.getJcbProduto().addItem(listaEstoque.getProdutoIdProduto().getDescricao());
                listaEstoques3.add(listaEstoque);
            } else {
                aux.add(listaEstoque);
            }
        }
        int i = 0;
        for (Estoque aux1 : aux) {
            if (listaEstoques.get(i) == aux1) {
                listaEstoques.remove(i++);
            }
        }
    }

    public void carregarComboCliente() {
        ClienteController controller = new ClienteController();
        try {
            listaClientes = controller.buscarTodos();

        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewVenda.getJcbCliente().removeAllItems();
        this.viewVenda.getJcbCliente().addItem(Mensagem.comboCliente);
        for (Cliente cliente : listaClientes) {
            this.viewVenda.getJcbCliente().addItem(cliente.getTipoPessoa().equals(Mensagem.pessoaFisica) ? cliente.getPessoaFisicaIdPessoaFisica().getNome() : cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }

    public void verificaIndex() {
        this.viewVenda.getJbtIniciarVenda().setEnabled(false);
        if (!Valida.testaZero(this.viewVenda.getJcbCliente().getSelectedIndex()) && !Valida.testaZero(this.viewVenda.getJcbFuncionario().getSelectedIndex())) {
            this.viewVenda.getJbtIniciarVenda().setEnabled(true);
            carregarComboDescricao();
        }
    }

    public void acaoBotaoIniciaVenda() {
        this.viewVenda.getJbtIniciarVenda().setEnabled(false);
        this.viewVenda.getJcbCliente().setEnabled(false);
        this.viewVenda.getJcbFuncionario().setEnabled(false);
        this.viewVenda.getJbtSair().setEnabled(false);
        this.viewVenda.getJbtConfirmar().setEnabled(true);
        this.viewVenda.getJbtSalvar().setEnabled(true);
        this.viewVenda.getJbtCancelar().setEnabled(true);
        this.viewVenda.getJbtExcluir().setEnabled(true);
        this.viewVenda.getJbtIncluirFormaPagamento().setEnabled(true);
        this.viewVenda.getJbtExcluirFormaPagamento().setEnabled(true);
        liberarCampos();
        listaEstoques2 = new ArrayList<Estoque>();
        formaPagamento = null;
    }

    public void liberarCampos() {
        this.viewVenda.getJcbProduto().grabFocus();
        this.viewVenda.getJtfDesconto().setEditable(true);
        this.viewVenda.getJtfDescontoPagamento().setEditable(true);
        this.viewVenda.getJtfQuantidade().setEditable(true);
        this.viewVenda.getJcbFormaPagamento().setEnabled(true);
        this.viewVenda.getJcbProduto().setEnabled(true);

    }

    public void bloqueioInicial() {
        this.viewVenda.getJbtSair().setEnabled(true);
        bloquearCampos();
        this.viewVenda.getJcbFuncionario().setEnabled(true);
        this.viewVenda.getJcbCliente().setEnabled(true);
    }

    public void bloquearCampos() {

        this.viewVenda.getJtfDesconto().setEditable(false);
        this.viewVenda.getJtfQuantidade().setEditable(false);
        this.viewVenda.getJtfDescontoPagamento().setEditable(false);
        this.viewVenda.getJcbFormaPagamento().setEnabled(false);
        this.viewVenda.getJcbProduto().setEnabled(false);
        this.viewVenda.getJbtExcluir().setEnabled(false);
        this.viewVenda.getJbtSalvar().setEnabled(false);
        this.viewVenda.getJbtCancelar().setEnabled(false);
        this.viewVenda.getJbtConfirmar().setEnabled(false);
        this.viewVenda.getJbtExcluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJbtIncluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJbtIniciarVenda().setEnabled(false);
    }

    public void acaoBotaoSalvar() {
        if (validaAdicionaProduto()) {
            estoque = listaEstoques.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1);
            DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
            double valTotal = Double.parseDouble(this.viewVenda.getJtfQuantidade().getText()) * estoque.getProdutoIdProduto().getValorVenda();
            valTotal = valTotal - (this.viewVenda.getJtfDesconto().getText().equals(Mensagem.vazio) ? 0 : Double.parseDouble(this.viewVenda.getJtfDesconto().getText()));
            EstoqueController estoqueController = new EstoqueController();
            estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() - Integer.parseInt(this.viewVenda.getJtfQuantidade().getText()));
            estoqueController.salvar(estoque);
            listaEstoques2.add(estoque);
            modelo.addRow(new String[]{estoque.getProdutoIdProduto().getDescricao(), this.viewVenda.getJtfQuantidade().getText(), "R$" + estoque.getProdutoIdProduto().getValorVenda(), this.viewVenda.getJtfDesconto().getText() + "", "R$" + valTotal});
            verificaValorTotal();
            this.viewVenda.getJcbProduto().setSelectedIndex(0);
            this.viewVenda.getJtfDesconto().setText(null);
            this.viewVenda.getJtfQuantidade().setText(null);
        }
    }

    public boolean validaAdicionaProduto() {
        if (Valida.testaZero(this.viewVenda.getJcbProduto().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaProduto);
            return false;
        }

        if (Valida.vazio(this.viewVenda.getJtfQuantidade().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaQtde);
            return false;
        }

        if (!Valida.valor(this.viewVenda.getJtfQuantidade().getText()) || Valida.negativo(Integer.parseInt(this.viewVenda.getJtfQuantidade().getText()))) {
            JOptionPane.showMessageDialog(null, Mensagem.informaQtdeValida);
            return false;
        }

        if (!Valida.vazio(this.viewVenda.getJtfDesconto().getText())) {
            if (!Valida.valor(this.viewVenda.getJtfDesconto().getText()) || Valida.negativo(Integer.parseInt(this.viewVenda.getJtfDesconto().getText()))) {
                JOptionPane.showMessageDialog(null, Mensagem.informaDescontoValido);
                return false;
            }
            if (Valida.xMaiorQueY(Double.parseDouble(this.viewVenda.getJtfDesconto().getText()), (listaEstoques3.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1).getProdutoIdProduto().getValorVenda())*(Integer.parseInt(this.viewVenda.getJtfQuantidade().getText())))) {
                JOptionPane.showMessageDialog(null, Mensagem.descontoMaior);
                return false;
            }
        }

        if (!Valida.estoque(Integer.parseInt(this.viewVenda.getJtfQuantidade().getText()), listaEstoques.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1))) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoSemEstoque(listaEstoques.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1).getProdutoIdProduto().getDescricao(), (listaEstoques.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1).getQuantidadeEstoque()) - listaEstoques.get(this.viewVenda.getJcbProduto().getSelectedIndex() - 1).getQuantidadeMinima()));
            return false;
        }
        return true;
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
        modelo.setRowCount(0);
        for (Estoque estoque1 : listaEstoques) {
            modelo.addRow(new String[]{estoque1.getProdutoIdProduto().getDescricao(), estoque1.getProdutoIdProduto().getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), estoque1.getProdutoIdProduto().getValorCusto() + "", estoque1.getProdutoIdProduto().getValorVenda() + ""});
        }
    }

    public void excluirProduto() {
        if (this.viewVenda.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaEstoque);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao, JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);
            estoque = listaEstoques2.get(this.viewVenda.getTabelaProduto().getSelectedRow());
            if (opcao == JOptionPane.YES_OPTION) {
                estoque.setQuantidadeEstoque(Integer.parseInt(modelo.getValueAt(this.viewVenda.getTabelaProduto().getSelectedRow(), 1).toString()) + estoque.getQuantidadeEstoque());
                EstoqueController controllerEstoque = new EstoqueController();
                controllerEstoque.salvar(estoque);
                listaEstoques2.remove(this.viewVenda.getTabelaProduto().getSelectedRow());
                modelo.removeRow(this.viewVenda.getTabelaProduto().getSelectedRow());
                verificaValorTotal();
            }
        }
    }

    public void acaoBotaoCancelar() {
        this.viewVenda.getJbtExcluir().setEnabled(true);
        this.viewVenda.getJbtSair().setEnabled(true);
        this.viewVenda.getJbtSalvar().setEnabled(false);
        this.viewVenda.getJbtCancelar().setEnabled(false);
        this.viewVenda.getJbtConfirmar().setEnabled(false);
        this.viewVenda.getJbtExcluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJbtIncluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJcbCliente().setEnabled(true);
        this.viewVenda.getJcbFuncionario().setEnabled(true);
        voltaEstoque();
        limparCampos();
        bloquearCampos();
    }

    public void limparCampos() {
        DefaultTableModel modeloProduto = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
        modeloProduto.setRowCount(0);
        DefaultTableModel modeloFormaPgto = (DefaultTableModel) this.viewVenda.getTabelaFormaPagamento().getModel();
        modeloFormaPgto.setRowCount(0);

        this.viewVenda.getJtfDesconto().setText(null);
        this.viewVenda.getJtfQuantidade().setText(null);
        this.viewVenda.getJtfDescontoPagamento().setText(null);
        this.viewVenda.getJcbFormaPagamento().setSelectedIndex(0);
        this.viewVenda.getJcbProduto().setSelectedIndex(0);
        this.viewVenda.getJbtExcluir().setEnabled(false);
        this.viewVenda.getJbtSalvar().setEnabled(false);
        this.viewVenda.getJbtCancelar().setEnabled(false);
        this.viewVenda.getJbtConfirmar().setEnabled(false);
        this.viewVenda.getJbtExcluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJbtIncluirFormaPagamento().setEnabled(false);
        this.viewVenda.getJbtIniciarVenda().setEnabled(false);
        this.viewVenda.getJlbValorTotal().setText(null);
        this.viewVenda.getJcbCliente().setSelectedIndex(0);
        this.viewVenda.getJcbFuncionario().setSelectedIndex(0);
    }

    public void voltaEstoque() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
        for (Estoque estoque1 : listaEstoques2) {
            estoque1.setQuantidadeEstoque(Integer.parseInt(modelo.getValueAt(0, 1).toString()) + estoque1.getQuantidadeEstoque());
            EstoqueController controllerEstoque = new EstoqueController();
            controllerEstoque.salvar(estoque1);
            modelo.removeRow(0);
        }
    }

    public void verificaValorTotal() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
        valorTotal = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            valorTotal += Double.parseDouble(modelo.getValueAt(i, 4).toString().replace(Mensagem.real, Mensagem.vazio));
        }
        String valorFormatado = new DecimalFormat(Mensagem.decimalFormat).format(valorTotal);
        this.viewVenda.getJlbValorTotal().setText(Mensagem.real + valorFormatado);
    }

    public void carregarTabelaFormaPgto() {
        if (validaSalvarPagamento()) {
            DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaFormaPagamento().getModel();
            if (modelo.getRowCount() == 1) {
                JOptionPane.showMessageDialog(null, Mensagem.erroIncluirFormaPgto);
            } else {
                modelo.addRow(new String[]{this.viewVenda.getJcbFormaPagamento().getSelectedItem().toString()});
                this.viewVenda.getJcbFormaPagamento().setSelectedIndex(0);
            }
        }
    }

    public void excluirFormaDePagamento() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaFormaPagamento().getModel();
        if (this.viewVenda.getTabelaFormaPagamento().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFormaPgto);
        } else {
            this.viewVenda.getTabelaFormaPagamento().getSelectedRow();
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                modelo.setRowCount(0);
            }
        }
    }

    public boolean validaSalvarPagamento() {
        if (Valida.testaZero(this.viewVenda.getJcbFormaPagamento().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informeFormaPgto);
            return false;
        }
        return true;
    }

    public void acaoBotaoVenda() {
        if (validaSalvar()) {
            Venda venda = new Venda();
            venda.setClienteIdCliente(listaClientes.get(this.viewVenda.getJcbCliente().getSelectedIndex() - 1));
            venda.setFuncionarioIdFuncionario(listaFuncionarios.get(this.viewVenda.getJcbCliente().getSelectedIndex() - 1));

            Calendar cal = Calendar.getInstance();
            int anoAtual = cal.get(Calendar.YEAR);
            int mesAtual = cal.get(Calendar.MONTH) + 1;
            int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
            String dataAtual = diaAtual + "/" + (mesAtual > 9 ? mesAtual : "0" + mesAtual) + "/" + anoAtual;

            venda.setDataVenda(dataAtual);
            venda.setFormaPagamento(this.viewVenda.getTabelaFormaPagamento().getValueAt(0, 0).toString());
            venda.setValorTotal(Double.parseDouble(this.viewVenda.getJlbValorTotal().getText().replace(Mensagem.real, Mensagem.vazio).replace(Mensagem.ponto, Mensagem.vazio).replace(Mensagem.virgula, Mensagem.ponto)));

            VendaDAO dao = new VendaDAO();
            dao.salvar(venda);
            LogUsuarioController controllerLogUsuario = new LogUsuarioController();
            Funcionario func1 = controllerLogUsuario.buscaFuncionario();
            salvarTimeStamp(func1, Mensagem.salvar);

            formaPagamento = this.viewVenda.getTabelaFormaPagamento().getValueAt(0, 0).toString();
            if (formaPagamento.equals(Mensagem.dinheiro) || formaPagamento.equals(Mensagem.debito)) {
                ContasReceberController controllerReceber = new ContasReceberController();
                ContasReceber aReceber = new ContasReceber();
                aReceber.setDataVencimento(dataAtual);
                aReceber.setDataPagamento(dataAtual);
                aReceber.setPagamento(Mensagem.sim);
                aReceber.setVencida(Mensagem.nao);
                aReceber.setVendaIdVenda(venda);
                controllerReceber.salvar(aReceber);
            }

            DefaultTableModel modelo = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setDescontoProduto(modelo.getValueAt(i, 3).toString().equals(Mensagem.vazio) ? 0 : Double.parseDouble(modelo.getValueAt(i, 3).toString()));
                itemVenda.setProdutoIdProduto(listaEstoques2.get(i).getProdutoIdProduto());
                itemVenda.setQuantidadeProduto(modelo.getValueAt(i, 1).toString().equals(Mensagem.vazio) ? 0 : Integer.parseInt(modelo.getValueAt(i, 1).toString()));
                itemVenda.setValorTotal(Double.parseDouble(modelo.getValueAt(i, 4).toString().replace(Mensagem.real, Mensagem.vazio)));
                itemVenda.setVendaIdVenda(venda);
                ItemVendaController itemVendaController = new ItemVendaController();
                itemVendaController.salvar(itemVenda);
            }

            limparCampos();
            bloqueioInicial();
            JOptionPane.showMessageDialog(null, Mensagem.vendaSucesso);
            tipoPagamento();
        }
    }

    public void tipoPagamento() {
        if (!formaPagamento.equals(Mensagem.dinheiro) && !formaPagamento.equals(Mensagem.debito)) {
            new ContasReceberPrincipal();
        }
    }

    public boolean validaSalvar() {
        DefaultTableModel modeloTabelaProduto = (DefaultTableModel) this.viewVenda.getTabelaProduto().getModel();
        DefaultTableModel modeloTabelaFormaPagamento = (DefaultTableModel) this.viewVenda.getTabelaFormaPagamento().getModel();

        if (!Valida.xMaiorQueY(modeloTabelaProduto.getRowCount(), 0)) {
            JOptionPane.showMessageDialog(null, Mensagem.adicioneProduto);
            return false;
        }

        if (!Valida.xMaiorQueY(modeloTabelaFormaPagamento.getRowCount(), 0)) {
            JOptionPane.showMessageDialog(null, Mensagem.informeFormaPgto);
            return false;
        }
        return true;
    }

    public void acaoDesconto() {
        try {
            if (Valida.vazio(this.viewVenda.getJtfDescontoPagamento().getText())) {
                this.viewVenda.getJtfDescontoPagamento().setText(null);
                verificaValorTotal();
            }

            if (Valida.espacos(this.viewVenda.getJtfDescontoPagamento().getText())) {
                this.viewVenda.getJtfDescontoPagamento().setText(null);
                verificaValorTotal();
            }

            if (Valida.xMaiorQueY(Double.parseDouble(this.viewVenda.getJtfDescontoPagamento().getText().replace(Mensagem.virgula, Mensagem.ponto)), valorTotal)) {
                this.viewVenda.getJtfDescontoPagamento().setText(null);
                verificaValorTotal();
            }
            double aux = valorTotal - Double.parseDouble(this.viewVenda.getJtfDescontoPagamento().getText().replace(Mensagem.virgula, Mensagem.ponto));
            String valorFormatado = new DecimalFormat(Mensagem.decimalFormat).format(aux);
            this.viewVenda.getJlbValorTotal().setText(Mensagem.real + valorFormatado);
        } catch (NumberFormatException N) {
            this.viewVenda.getJtfDescontoPagamento().setText(null);
            verificaValorTotal();
        }
    }

    public Venda retornaUltimaVenda() {
        VendaDAO dao = new VendaDAO();
        ArrayList<Venda> aux = new ArrayList<Venda>();
        Venda venda = new Venda();
        try {
            aux = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Venda aux1 : aux) {
            venda = aux1;
        }
        return venda;
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
        logUsuario.setTabela(Mensagem.venda);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
