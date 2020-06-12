package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ProdutoDAO;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.Produto;

import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.ProdutoPrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ProdutoController {

    private ProdutoPrincipal viewProduto;
    private Produto produto = new Produto();
    private List<Produto> listaProdutos;
    private List<Fornecedor> listaFornecedores;
    Fornecedor fornecedor = new Fornecedor();
    FornecedorController controllerFornecedor = new FornecedorController();
    private boolean alterar;

    public ProdutoController(ProdutoPrincipal viewProduto) {
        this.viewProduto = viewProduto;
    }

    public ProdutoController() {
    }

    public void listarProdutos() {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            listaProdutos = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        modelo.setRowCount(0);
        for (Produto produto : listaProdutos) {
            modelo.addRow(new String[]{produto.getDescricao(), produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), produto.getValorCusto() + "", produto.getValorVenda() + ""});

        }
    }

    public void bloqueioInicial() {
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        this.viewProduto.getJbtConfirmar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewProduto.getJtfPesquisarDescricao().setEditable(true);
        this.viewProduto.getJtfPesquisarDescricao().grabFocus();
        this.viewProduto.getJtfDescricao().setEditable(false);
        this.viewProduto.getJtfValorCusto().setEditable(false);
        this.viewProduto.getJtfValorVenda().setEditable(false);
        this.viewProduto.getJcbFornecedor().setEnabled(false);

    }

    public void acaoBotaoNovo() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        this.viewProduto.getJbtConfirmar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void carregarComboProduto() {
        FornecedorController controller = new FornecedorController();
        try {
            listaFornecedores = controller.buscarFornecedores();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewProduto.getJcbFornecedor().removeAllItems();
        this.viewProduto.getJcbFornecedor().addItem(Mensagem.comboFornecedor);
        for (Fornecedor listafor : listaFornecedores) {
            this.viewProduto.getJcbFornecedor().addItem(listafor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }

    public void liberarCampos() {
        this.viewProduto.getJtfPesquisarDescricao().setEditable(false);
        this.viewProduto.getJtfDescricao().grabFocus();
        this.viewProduto.getJtfDescricao().setEditable(true);
        this.viewProduto.getJtfValorCusto().setEditable(true);
        this.viewProduto.getJtfValorVenda().setEditable(true);
        this.viewProduto.getJcbFornecedor().setEnabled(true);

    }

    public void acaoBotaoCancelar() {
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        this.viewProduto.getJbtConfirmar().setEnabled(false);

        limparCampos();
        bloquearCampos();
    }

    public boolean validarSalvar() {

        if (this.viewProduto.getJtfDescricao() == null || this.viewProduto.getJtfDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDescricao);
            return false;
        }

        if (this.viewProduto.getJtfValorCusto() == null || this.viewProduto.getJtfValorCusto().equals("")) {
            JOptionPane.showMessageDialog(null, Mensagem.informaValorCusto);
            return false;
        }

        if (this.viewProduto.getJtfValorVenda().getText().trim().equals("") || this.viewProduto.getJtfValorVenda().getText() == null) {
            JOptionPane.showMessageDialog(null, Mensagem.informaValorVenda);
            return false;
        }
        if (this.viewProduto.getJcbFornecedor().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, Mensagem.informaFornecedor);
            return false;
        }

        return true;

    }

    public boolean verificarValorVenda() {
        return this.viewProduto.getJtfValorVenda().getText().trim().matches("[0-9]+");

    }

    public boolean verificarValorCusto() {
        return this.viewProduto.getJtfValorCusto().getText().trim().matches("[0-9]+");

    }

    public void salvarProduto() {
        if (this.alterar == false) {
            //inserir um registro
            if (validarSalvar()) {
                produto = new Produto();
                fornecedor = listaFornecedores.get(this.viewProduto.getJcbFornecedor().getSelectedIndex() - 1);
                produto.setFornecedorIdFornecedor(fornecedor);

                produto.setDescricao(this.viewProduto.getJtfDescricao().getText());
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText().replace(Mensagem.virgula, Mensagem.ponto)));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText().replace(Mensagem.virgula, Mensagem.ponto)));

                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.salvar(produto);
                    JOptionPane.showMessageDialog(null, Mensagem.inserirEstoque);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroInserirEstoque);
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.salvar);

                limparCampos();
                bloqueioInicial();
                listarProdutos();
            }
        } else {
            //alterando o registro
            if (validarSalvar()) {
                fornecedor = listaFornecedores.get(this.viewProduto.getJcbFornecedor().getSelectedIndex() - 1);
                produto.setFornecedorIdFornecedor(fornecedor);
                produto.setDescricao(this.viewProduto.getJtfDescricao().getText());
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText().replace(Mensagem.virgula, Mensagem.ponto)));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText().replace(Mensagem.virgula, Mensagem.ponto)));

                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.salvar(produto);
                    JOptionPane.showMessageDialog(null, Mensagem.alterarEstoque);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroAlterarEstoque);
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.alterar);
                limparCampos();
                bloqueioInicial();
                listarProdutos();
            }
        }
    }

    public void alterarProduto() {
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaProduto);
        } else {
            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            this.viewProduto.getJtfDescricao().setText(produto.getDescricao());
            this.viewProduto.getJtfValorCusto().setText(produto.getValorCusto() + "");
            this.viewProduto.getJtfValorVenda().setText(produto.getValorVenda() + "");
            this.viewProduto.getJcbFornecedor().setSelectedItem(produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void acaoBotaoAlterar() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        this.viewProduto.getJbtConfirmar().setEnabled(true);
        liberarCampos();
        this.viewProduto.getJtfDescricao().setEditable(false);

    }

    public void excluirProduto() {
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaProduto);
        } else {

            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.excluir(produto);
                    LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                    Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                    salvarTimeStamp(func1, "EXCLUIR");
                    JOptionPane.showMessageDialog(null, Mensagem.exclusaoEstoque);
                    listarProdutos();
                } catch (Exception ex) {
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void limparCampos() {
        this.viewProduto.getJtfDescricao().setText(null);
        this.viewProduto.getJtfValorCusto().setText(null);
        this.viewProduto.getJtfValorVenda().setText(null);
        this.viewProduto.getJcbFornecedor().setSelectedIndex(0);
    }

    public ArrayList<Produto> buscarProdutos() throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> listaProdutos1 = dao.buscarTodos();
        return listaProdutos1;
    }

    public List<Produto> buscarTodos(int idProduto) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> listaProdutos = null;
        try {
            listaProdutos = dao.buscarTodos(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
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
        logUsuario.setTabela(Mensagem.produto);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

}
