package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.CompraDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.ItemCompra;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.CompraPrincipal;
import br.com.foursys.vendas.view.ContasPagarPrincipal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class CompraController {

    private CompraPrincipal viewCompra;
    private Compra compra = new Compra();
    private Fornecedor fornecedor = new Fornecedor();
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Fornecedor> listaFornecedores;
    private ArrayList<Produto> listaProdutos;
    private ArrayList<Produto> listaProdutos2;
    private ArrayList<Produto> listaProdutos3;
    private ArrayList<Estoque> listaEstoque;
    private boolean alterar;
    private String formaPagamento;

    public CompraController() {
    }

    public CompraController(CompraPrincipal viewCompra) {
        this.viewCompra = viewCompra;
    }

    public void carregarComboFuncionario() {
        FuncionarioController controller = new FuncionarioController();
        try {
            listaFuncionarios = controller.buscarFuncionarios();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCompra.getJcbFuncionario().removeAllItems();
        this.viewCompra.getJcbFuncionario().addItem(Mensagem.comboFuncionario);
        for (Funcionario listaFuncionario : listaFuncionarios) {
            this.viewCompra.getJcbFuncionario().addItem(listaFuncionario.getPessoaFisicaIdPessoaFisica().getNome());
        }
    }

    public Estoque buscarProduto(int posicaoListaProduto) {
        Estoque estoque = null;
        EstoqueController controller = new EstoqueController();
        try {
            listaEstoque = controller.buscarEstoques();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Estoque listaEstoque1 : listaEstoque) {
            if (Objects.equals(listaEstoque1.getProdutoIdProduto().getIdProduto(), listaProdutos.get(posicaoListaProduto).getIdProduto())) {
                estoque = listaEstoque1;

            }
        }

        return estoque;
    }

    public void carregarComboDescricao() {
        ProdutoController controller = new ProdutoController();
        try {
            listaProdutos = controller.buscarProdutos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCompra.getJcbProduto().removeAllItems();
        this.viewCompra.getJcbProduto().addItem(Mensagem.comboProduto);
        for (Produto listaProduto : listaProdutos) {
            if (Objects.equals(listaProduto.getFornecedorIdFornecedor().getIdFornecedor(), listaFornecedores.get(this.viewCompra.getJcbFornecedor().getSelectedIndex() - 1).getIdFornecedor())) {
                this.viewCompra.getJcbProduto().addItem(listaProduto.getDescricao());
                listaProdutos3.add(listaProduto);
            }
        }
    }

    public void carregarComboFornecedor() {
        FornecedorController controller = new FornecedorController();
        try {
            listaFornecedores = controller.buscarFornecedores();

        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCompra.getJcbFornecedor().removeAllItems();
        this.viewCompra.getJcbFornecedor().addItem(Mensagem.comboFornecedor);
        for (Fornecedor fornecedor : listaFornecedores) {
            this.viewCompra.getJcbFornecedor().addItem(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }

    public void carregarComboFormaPgto() {
        this.viewCompra.getJcbFormaPgto().removeAllItems();
        this.viewCompra.getJcbFormaPgto().addItem(Mensagem.comboFormaPgto);
        this.viewCompra.getJcbFormaPgto().addItem(Mensagem.dinheiro);
        this.viewCompra.getJcbFormaPgto().addItem(Mensagem.debito);
        this.viewCompra.getJcbFormaPgto().addItem(Mensagem.credito);
        this.viewCompra.getJcbFormaPgto().addItem(Mensagem.cheque);

    }

    public void verificaIndex() {
        this.viewCompra.getJbtIniciar().setEnabled(false);

        if (!Valida.testaZero(this.viewCompra.getJcbFornecedor().getSelectedIndex()) && !Valida.testaZero(this.viewCompra.getJcbFuncionario().getSelectedIndex())) {
            this.viewCompra.getJbtIniciar().setEnabled(true);
        }
    }

    public void acaoBotaoIniciaVenda() {
        this.viewCompra.getJbtIniciar().setEnabled(false);
        this.viewCompra.getJcbFornecedor().setEnabled(false);
        this.viewCompra.getJcbFuncionario().setEnabled(false);
        this.viewCompra.getJbtSair().setEnabled(false);
        this.viewCompra.getJbtConfirmar().setEnabled(true);
        this.viewCompra.getJbtSalvar().setEnabled(true);
        this.viewCompra.getJbtCancelar().setEnabled(true);
        this.viewCompra.getJbtExcluir().setEnabled(true);
        this.viewCompra.getJbtIncluirPgto().setEnabled(true);
        this.viewCompra.getJbtExcluirPgto().setEnabled(true);

        liberarCampos();
        this.alterar = false;
        listaProdutos3 = new ArrayList<Produto>();
        listaProdutos2 = new ArrayList<Produto>();
        carregarComboDescricao();
    }

    public void liberarCampos() {
        this.viewCompra.getJcbProduto().grabFocus();
        this.viewCompra.getJtfQuantidade().setEditable(true);
        this.viewCompra.getJcbProduto().setEnabled(true);
        this.viewCompra.getJcbFormaPgto().setEnabled(true);

    }

    public void bloqueioInicial() {
        this.viewCompra.getJbtExcluir().setEnabled(true);
        this.viewCompra.getJbtSair().setEnabled(true);
        this.viewCompra.getJbtSalvar().setEnabled(false);
        this.viewCompra.getJbtCancelar().setEnabled(false);
        this.viewCompra.getJcbFornecedor().setEnabled(true);
        this.viewCompra.getJcbFuncionario().setEnabled(true);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewCompra.getJtfQuantidade().setEditable(false);
        this.viewCompra.getJcbFormaPgto().setEnabled(false);
        this.viewCompra.getJcbProduto().setEnabled(false);
        this.viewCompra.getJbtExcluir().setEnabled(false);
        this.viewCompra.getJbtSalvar().setEnabled(false);
        this.viewCompra.getJbtCancelar().setEnabled(false);
        this.viewCompra.getJbtConfirmar().setEnabled(false);
        this.viewCompra.getJbtExcluirPgto().setEnabled(false);
        this.viewCompra.getJbtIncluirPgto().setEnabled(false);
        this.viewCompra.getJbtIniciar().setEnabled(false);

    }

    public void acaoBotaoCancelar() {
        this.viewCompra.getJcbFornecedor().setEnabled(true);
        this.viewCompra.getJcbFuncionario().setEnabled(true);
        this.viewCompra.getJbtSair().setEnabled(true);

        limparCampos();
        bloquearCampos();
    }

    public void limparCampos() {
        DefaultTableModel modeloproduto = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
        modeloproduto.setRowCount(0);
        DefaultTableModel modeloformapgto = (DefaultTableModel) this.viewCompra.getTabelaPagamento().getModel();
        modeloformapgto.setRowCount(0);
        this.viewCompra.getJtfQuantidade().setText(null);
        this.viewCompra.getJlbValorTotal().setText(null);
        this.viewCompra.getJcbFormaPgto().setSelectedIndex(0);
        this.viewCompra.getJcbProduto().setSelectedIndex(0);
        this.viewCompra.getJcbFornecedor().setSelectedIndex(0);
        this.viewCompra.getJcbFuncionario().setSelectedIndex(0);

    }

    public void carregarTabelaProduto() {
        if (validarTabela()) {

            DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
            double valorTotal = 0;
            valorTotal += Integer.parseInt(this.viewCompra.getJtfQuantidade().getText()) * listaProdutos3.get(this.viewCompra.getJcbProduto().getSelectedIndex() - 1).getValorCusto();
            Produto produtos = listaProdutos3.get(this.viewCompra.getJcbProduto().getSelectedIndex() - 1);
            modelo.addRow(new String[]{produtos.getDescricao(), this.viewCompra.getJtfQuantidade().getText(), "R$ " + produtos.getValorCusto(), "R$ " + valorTotal});
            verificaValorTotal();
            listaProdutos2.add(produtos);
            this.viewCompra.getJcbProduto().setSelectedIndex(0);
            this.viewCompra.getJtfQuantidade().setText(Mensagem.vazio);
        }
    }

    public void excluirProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
        if (this.viewCompra.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaProduto);
        } else {
            this.viewCompra.getTabelaProduto().getSelectedRow();
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                listaProdutos2.remove(this.viewCompra.getTabelaProduto().getSelectedRow());
                modelo.removeRow(this.viewCompra.getTabelaProduto().getSelectedRow());
                verificaValorTotal();
            }
        }
    }

    public void carregarTabelaFormaPgto() {
        if (validaSalvarPagamento()) {
            DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaPagamento().getModel();
            if (modelo.getRowCount() == 1) {
                JOptionPane.showMessageDialog(null, Mensagem.erroIncluirFormaPgto);
            } else {
                modelo.addRow(new String[]{this.viewCompra.getJcbFormaPgto().getSelectedItem().toString()});
                this.viewCompra.getJcbFormaPgto().setSelectedIndex(0);
            }

        }

    }

    public void excluirFormaPgto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaPagamento().getModel();
        if (this.viewCompra.getTabelaPagamento().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFormaPgto);
        } else {
            this.viewCompra.getTabelaPagamento().getSelectedRow();
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                modelo.setRowCount(0);

            }
        }
    }

    public boolean validaSalvar() {
        DefaultTableModel modeloproduto = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
        if (Valida.testaZero(modeloproduto.getRowCount())) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaProduto);
            return false;
        }

        DefaultTableModel modeloformapgto = (DefaultTableModel) this.viewCompra.getTabelaPagamento().getModel();

        if (Valida.testaZero(modeloformapgto.getRowCount())) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFormaPgto);
            return false;
        }

        return true;

    }

    public boolean validarTabela() {

        if (Valida.vazio(this.viewCompra.getJtfQuantidade().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaQtde);
            this.viewCompra.getJtfQuantidade().setText(null);
            this.viewCompra.getJtfQuantidade().grabFocus();
            return false;
        }
        if (!Valida.numero(this.viewCompra.getJtfQuantidade().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.qtdeValida);
            this.viewCompra.getJtfQuantidade().setText(null);
            this.viewCompra.getJtfQuantidade().grabFocus();
            return false;
        }
        if (Valida.negativo(Integer.parseInt(this.viewCompra.getJtfQuantidade().getText()))) {
            JOptionPane.showMessageDialog(null, Mensagem.qtdeValida);
            this.viewCompra.getJtfQuantidade().setText(null);
            verificaValorTotal();
        }

        return true;
    }

    public boolean validaSalvarPagamento() {
        if (Valida.testaZero(this.viewCompra.getJcbFormaPgto().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informeFormaPgto);
            return false;
        }
        return true;
    }

    public void verificaValorTotal() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
        double valorTotal = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            valorTotal += Double.parseDouble(modelo.getValueAt(i, 3).toString().replace(Mensagem.real, Mensagem.vazio));
        }
        this.viewCompra.getJlbValorTotal().setText(Mensagem.real + valorTotal);
    }

    public void apagarErroQtde() {
        try {
            if (Valida.vazio(this.viewCompra.getJtfQuantidade().getText())) {
                this.viewCompra.getJtfQuantidade().setText(null);
                verificaValorTotal();
            }

            if (Valida.espacos(this.viewCompra.getJtfQuantidade().getText())) {
                this.viewCompra.getJtfQuantidade().setText(null);
                verificaValorTotal();
            }

        } catch (NumberFormatException N) {
            this.viewCompra.getJtfQuantidade().setText(null);
            verificaValorTotal();
        }
    }

    public void acaoValor() {
        try {
            DecimalFormat valorFormatado = new DecimalFormat(Mensagem.decimalFormat);
            this.viewCompra.getJlbValorTotal().setText(Mensagem.dinheiro + valorFormatado);
        } catch (NumberFormatException N) {
            verificaValorTotal();
        }
    }

    public void salvarProduto() {
        if (this.alterar == false) {
            //inserir um registro
            if (validaSalvar()) {
                compra = new Compra();
                Calendar cal = Calendar.getInstance();

                int anoAtual = cal.get(Calendar.YEAR);
                int mesAtual = cal.get(Calendar.MONTH) + 1;
                int diaAtual = cal.get(Calendar.DAY_OF_MONTH);

                String dataAtual = diaAtual + "/" + mesAtual + "/" + anoAtual;

                compra.setDataCompra(dataAtual);
                compra.setValorTotal(Double.parseDouble(this.viewCompra.getJlbValorTotal().getText().replace(Mensagem.real, Mensagem.vazio).replace(Mensagem.dinheiro, Mensagem.vazio)));
                compra.setFormaPagamento(this.viewCompra.getTabelaPagamento().getValueAt(0, 0).toString());

                compra.setFuncionarioIdFuncionario(listaFuncionarios.get(this.viewCompra.getJcbFuncionario().getSelectedIndex() - 1));
                compra.setFornecedorIdFornecedor(listaFornecedores.get(this.viewCompra.getJcbFornecedor().getSelectedIndex() - 1));

                formaPagamento = this.viewCompra.getTabelaPagamento().getValueAt(0, 0).toString();

                CompraDAO dao = new CompraDAO();
                dao.salvar(compra);
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.salvar);

                if (formaPagamento.equals(Mensagem.dinheiro) || formaPagamento.equals(Mensagem.debito)) {
                    ContasPagarController controllerPagar = new ContasPagarController();
                    ContasPagar aPagar = new ContasPagar();

                    aPagar.setDataVencimento(dataAtual);
                    aPagar.setDataPagamento(dataAtual);
                    aPagar.setPagamento(Mensagem.sim);
                    aPagar.setVencida(Mensagem.nao);
                    aPagar.setCompraIdCompra(compra);
                    controllerPagar.salvar(aPagar);
                }

                DefaultTableModel modelo = (DefaultTableModel) this.viewCompra.getTabelaProduto().getModel();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    ItemCompra itemCompra = new ItemCompra();

                    itemCompra.setQuantidadeProduto(modelo.getValueAt(i, 1).toString().equals(Mensagem.vazio) ? "0" : (modelo.getValueAt(i, 1).toString()));
                    itemCompra.setValorTotal(Double.parseDouble(modelo.getValueAt(i, 3).toString().replace(Mensagem.real, Mensagem.vazio)));
                    itemCompra.setCompraIdCompra(compra);
                    itemCompra.setProdutoIdProduto(listaProdutos2.get(i));

                    ItemCompraController controllercompra = new ItemCompraController();
                    controllercompra.salvar(itemCompra);

                    EstoqueController controllerEst = new EstoqueController();
                    Estoque estoque = controllerEst.buscaEstoque(listaProdutos2.get(i));
                    estoque.setProdutoIdProduto(listaProdutos2.get(i));
                    estoque.setQuantidadeMinima(estoque.getQuantidadeMinima() == null ? 5 : estoque.getQuantidadeMinima());
                    estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque() == null ? Integer.parseInt(modelo.getValueAt(i, 1).toString()) : estoque.getQuantidadeEstoque() + Integer.parseInt(modelo.getValueAt(i, 1).toString()));

                    controllerEst.salvar(estoque);

                }
                JOptionPane.showMessageDialog(null, Mensagem.inserirCompra);
                limparCampos();
                bloqueioInicial();

                tipoPagamento();
            }
        }
    }

    public void tipoPagamento() {
        if (!formaPagamento.equals(Mensagem.dinheiro) && !formaPagamento.equals(Mensagem.debito)) {
            new ContasPagarPrincipal();
        }
    }

    public Compra retornaUltimaCompra() {
        CompraDAO dao = new CompraDAO();
        ArrayList<Compra> aux = new ArrayList<Compra>();
        Compra compra = new Compra();
        try {
            aux = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Compra aux1 : aux) {
            compra = aux1;
        }
        return compra;
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
        logUsuario.setTabela(Mensagem.compra);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
