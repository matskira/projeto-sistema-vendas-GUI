package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.EstoqueDAO;
import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.EstoquePrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EstoqueController {

    private EstoquePrincipal viewEstoque;
    private ArrayList<Produto> listaProdutos;
    private ArrayList<Estoque> listaEstoques;
    private ArrayList<Estoque> listaEstoques2;
    private boolean alterar;
    private Estoque estoque = new Estoque();

    public EstoqueController(EstoquePrincipal viewEstoque) {
        this.viewEstoque = viewEstoque;
    }

    public EstoqueController() {
    }

    public void carregarComboProdutos() {
        ProdutoController controller = new ProdutoController();
        try {
            listaProdutos = controller.buscarProdutos();

        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewEstoque.getJcbEstoque().removeAllItems();
        this.viewEstoque.getJcbEstoque().addItem(Mensagem.comboProdutoFornecedor);
        for (Produto listaFornecedor : listaProdutos) {
            this.viewEstoque.getJcbEstoque().addItem(listaFornecedor.getDescricao() + " - " + listaFornecedor.getFornecedorIdFornecedor().getContato());
        }
    }

    public void listarItensEstoque() {
        try {
            EstoqueDAO dao = new EstoqueDAO();
            listaEstoques = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        listaEstoques2 = new ArrayList<Estoque>();
        DefaultTableModel modelo = (DefaultTableModel) this.viewEstoque.getTabelaEstoque().getModel();
        modelo.setRowCount(0);
        for (Estoque listaEstoque : listaEstoques) {
            modelo.addRow(new String[]{listaEstoque.getProdutoIdProduto().getDescricao(), listaEstoque.getProdutoIdProduto().getFornecedorIdFornecedor().getContato(), listaEstoque.getQuantidadeEstoque() + "", listaEstoque.getQuantidadeMinima() + ""});
            listaEstoques2.add(listaEstoque);
        }
    }

    public void bloqueioInicial() {
        this.viewEstoque.getJbtNovo().setEnabled(true);
        this.viewEstoque.getJbtAlterar().setEnabled(true);
        this.viewEstoque.getJbtExcluir().setEnabled(true);
        this.viewEstoque.getJbtSair().setEnabled(true);
        this.viewEstoque.getJbtSalvar().setEnabled(false);
        this.viewEstoque.getJbtCancelar().setEnabled(false);

        bloquearCampos();

    }

    public void bloquearCampos() {

        //campo de pesquisa de estoque , procurar produto
        this.viewEstoque.getJtfQtdeEstoque().setEditable(false);
        this.viewEstoque.getJtfQtdeMinima().setEditable(false);
        this.viewEstoque.getJcbEstoque().setEnabled(false);

    }

    public void liberarCampos() {
        this.viewEstoque.getJtfQtdeEstoque().setEditable(true);
        this.viewEstoque.getJtfQtdeMinima().setEditable(true);
        this.viewEstoque.getJcbEstoque().setEnabled(true);

    }

    public void limparCampos() {

        this.viewEstoque.getJtfQtdeEstoque().setText(null);
        this.viewEstoque.getJtfQtdeMinima().setText(null);
        this.viewEstoque.getJcbEstoque().setSelectedIndex(0);

    }

    public void acaoBotaoNovo() {
        this.viewEstoque.getJbtNovo().setEnabled(false);
        this.viewEstoque.getJbtAlterar().setEnabled(false);
        this.viewEstoque.getJbtExcluir().setEnabled(false);
        this.viewEstoque.getJbtSair().setEnabled(false);
        this.viewEstoque.getJbtSalvar().setEnabled(true);
        this.viewEstoque.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void acaoBotaoCancelar() {
        this.viewEstoque.getJbtNovo().setEnabled(true);
        this.viewEstoque.getJbtAlterar().setEnabled(true);
        this.viewEstoque.getJbtExcluir().setEnabled(true);
        this.viewEstoque.getJbtSair().setEnabled(true);
        this.viewEstoque.getJbtSalvar().setEnabled(false);
        this.viewEstoque.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewEstoque.getJbtNovo().setEnabled(false);
        this.viewEstoque.getJbtAlterar().setEnabled(false);
        this.viewEstoque.getJbtExcluir().setEnabled(false);
        this.viewEstoque.getJbtSair().setEnabled(false);
        this.viewEstoque.getJbtSalvar().setEnabled(true);
        this.viewEstoque.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewEstoque.getJtfQtdeEstoque().setEditable(true);
        this.viewEstoque.getJtfQtdeMinima().setEditable(true);
        this.viewEstoque.getJcbEstoque().setEnabled(false);
    }

    public void salvarEstoque() {
        if (validarSalvar()) {
            //inserir um registro;
            if (!this.alterar) {

                estoque = new Estoque();
                Produto produto = listaProdutos.get(this.viewEstoque.getJcbEstoque().getSelectedIndex() - 1);

                estoque.setProdutoIdProduto(produto);

                if (this.viewEstoque.getJtfQtdeEstoque().getText().trim().equals(Mensagem.vazio)) {
                    estoque.setQuantidadeEstoque(0);
                } else {
                    estoque.setQuantidadeEstoque(Integer.parseInt(this.viewEstoque.getJtfQtdeEstoque().getText()));
                }
                if (this.viewEstoque.getJtfQtdeMinima().getText().trim().equals(Mensagem.vazio)) {
                    estoque.setQuantidadeMinima(0);
                } else {
                    estoque.setQuantidadeMinima(Integer.parseInt(this.viewEstoque.getJtfQtdeMinima().getText()));
                }

                EstoqueDAO dao = new EstoqueDAO();
                try {
                    dao.salvar(estoque);
                    JOptionPane.showMessageDialog(null, Mensagem.inserirEstoque);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroInserirEstoque);
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, "SALVAR");
                limparCampos();
                bloqueioInicial();
                listarItensEstoque();
            } else {
                Produto produto = listaProdutos.get(this.viewEstoque.getJcbEstoque().getSelectedIndex() - 1);
                estoque.setProdutoIdProduto(produto);
                estoque = buscaEstoque(listaProdutos.get(this.viewEstoque.getJcbEstoque().getSelectedIndex() - 1));
                estoque.setQuantidadeMinima(this.viewEstoque.getJtfQtdeMinima().getText().equals(Mensagem.vazio) ? 0 : Integer.parseInt(this.viewEstoque.getJtfQtdeMinima().getText()));
                estoque.setQuantidadeEstoque(this.viewEstoque.getJtfQtdeEstoque().getText().equals(Mensagem.vazio) ? 0 : Integer.parseInt(this.viewEstoque.getJtfQtdeEstoque().getText()));

                EstoqueDAO dao = new EstoqueDAO();
                try {
                    dao.salvar(estoque);
                    JOptionPane.showMessageDialog(null, Mensagem.alterarEstoque);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroAlterarEstoque);
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, "ALTERAR");
                limparCampos();
                bloqueioInicial();
                listarItensEstoque();

            }
        }
    }

    public void alterarEstoque() {
        if (this.viewEstoque.getTabelaEstoque().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaEstoque);
        } else {
            estoque = listaEstoques2.get(this.viewEstoque.getTabelaEstoque().getSelectedRow());

            this.viewEstoque.getJcbEstoque().setSelectedItem(estoque.getProdutoIdProduto().getDescricao() + " - " + estoque.getProdutoIdProduto().getFornecedorIdFornecedor().getContato());
            this.viewEstoque.getJtfQtdeEstoque().setText(estoque.getQuantidadeEstoque() + "");
            this.viewEstoque.getJtfQtdeMinima().setText(estoque.getQuantidadeMinima() + "");

            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public boolean validarSalvar() {

        if (Valida.testaZero(this.viewEstoque.getJcbEstoque().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.erroComboProduto);
            return false;
        }

        if (!Valida.vazio(this.viewEstoque.getJtfQtdeEstoque().getText())) {
            if (!Valida.numero(this.viewEstoque.getJtfQtdeEstoque().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.qtdeValida);
                this.viewEstoque.getJtfQtdeEstoque().setText(null);
                this.viewEstoque.getJtfQtdeEstoque().grabFocus();
                return false;
            }
        }

        if (!Valida.vazio(this.viewEstoque.getJtfQtdeMinima().getText())) {
            if (!Valida.valor(this.viewEstoque.getJtfQtdeMinima().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.qtdeValida);
                this.viewEstoque.getJtfQtdeMinima().setText(null);
                this.viewEstoque.getJtfQtdeMinima().grabFocus();
                return false;
            }
            if (Valida.xMaiorQueY(Integer.parseInt(this.viewEstoque.getJtfQtdeMinima().getText()), Integer.parseInt(this.viewEstoque.getJtfQtdeEstoque().getText()))) {
                JOptionPane.showMessageDialog(null, Mensagem.qtdeCadastradaInvalida);
                this.viewEstoque.getJtfQtdeMinima().setText(null);
                this.viewEstoque.getJtfQtdeMinima().grabFocus();
                return false;
            }
        }

        return true;
    }

    public void excluirEstoque() {
        if (this.viewEstoque.getTabelaEstoque().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaEstoque);
        } else {
            estoque = listaEstoques2.get(this.viewEstoque.getTabelaEstoque().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                EstoqueDAO dao = new EstoqueDAO();
                try {
                    listaEstoques2.remove(this.viewEstoque.getTabelaEstoque().getSelectedRow());
                    dao.excluir(estoque);
                    listarItensEstoque();
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueExcluido);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroExcluirEstoque);
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Estoque> buscarEstoques() throws Exception {
        EstoqueDAO dao = new EstoqueDAO();
        ArrayList<Estoque> listaEstoque = dao.buscarTodos();
        return listaEstoque;
    }

    public void salvar(Estoque estoque1) {
        EstoqueDAO dao = new EstoqueDAO();
        dao.salvar(estoque1);
    }

    public Estoque buscaEstoque(Produto produto) {
        ArrayList<Estoque> aux = new ArrayList<Estoque>();
        Estoque estoque1 = new Estoque();
        try {
            aux = buscarEstoques();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Estoque aux1 : aux) {
            if (Objects.equals(produto.getIdProduto(), aux1.getProdutoIdProduto().getIdProduto())) {
                return aux1;
            }
        }
        return estoque1;
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
        logUsuario.setTabela(Mensagem.estoque);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
