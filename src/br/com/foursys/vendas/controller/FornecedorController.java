package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.FornecedorDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.FornecedorPrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class FornecedorController {

    private FornecedorPrincipal viewFornecedor;
    Fornecedor fornecedor = new Fornecedor();
    private ArrayList<Fornecedor> listaFornecedores;
    private ArrayList<Cidade> listaCidades;
    private ArrayList<Estado> listaEstados;
    private boolean alterar;

    public FornecedorController(FornecedorPrincipal viewFornecedor) {
        this.viewFornecedor = viewFornecedor;
    }

    public FornecedorController() {
    }

    public void excluirFornecedor() {
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFornecedor);
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                FornecedorDAO dao = new FornecedorDAO();
                try {
                    dao.excluir(fornecedor);
                    LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                    Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                    salvarTimeStamp(func1, Mensagem.excluir);
                    new ContatoController().excluir(fornecedor.getContatoIdContato());
                    new EnderecoController().excluir(fornecedor.getEnderecoIdEndereco());
                    new PessoaJuridicaController().excluir(fornecedor.getPessoaJuridicaIdPessoaJuridica());

                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorExcluido);
                    listarFornecedores();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroExcluirFornecedor);
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void acaoBotaoSalvar() {
        if (validaSalvar()) {
            FornecedorDAO dao = new FornecedorDAO();
            Contato contato = new Contato();
            Endereco endereco = new Endereco();
            if (!this.alterar) {
                fornecedor = new Fornecedor();
                PessoaJuridicaController pessoaJuridicaController = new PessoaJuridicaController();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setCnpj(this.viewFornecedor.getJtfCnpj().getText());
                pessoaJuridica.setDataFundacao(this.viewFornecedor.getJtfDataFundacao().getText());
                pessoaJuridica.setRazaoSocial(this.viewFornecedor.getJtfRazaoSocial().getText());
                pessoaJuridica.setInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText().equals(Mensagem.mascaraIeSalva) ? null : this.viewFornecedor.getJtfInscricaoEstadual().getText());
                pessoaJuridicaController.salvar(pessoaJuridica);
                fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.salvar);
            } else {
                contato = fornecedor.getContatoIdContato();
                endereco = fornecedor.getEnderecoIdEndereco();
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.alterar);
            }
            contato = salvaContato(contato);
            endereco = salvaEndereco(endereco);
            fornecedor.setContato(this.viewFornecedor.getJtfContato().getText());
            fornecedor.setContatoIdContato(contato);
            fornecedor.setEnderecoIdEndereco(endereco);
            dao.salvar(fornecedor);
            JOptionPane.showMessageDialog(null, Mensagem.fornecedorSalvo);
            limparCampos();
            bloqueioInicial();
            listarFornecedores();
        }
    } // fim do método acaoBotaoSalvar

    public Contato salvaContato(Contato contato) {
        ContatoController contatoController = new ContatoController();
        contato.setCelular(this.viewFornecedor.getJtfCelular().getText().equals(Mensagem.mascaraCelular) ? null : this.viewFornecedor.getJtfCelular().getText());
        contato.setEmail(this.viewFornecedor.getJtfEmail().getText().equals(Mensagem.vazio) ? null : this.viewFornecedor.getJtfEmail().getText());
        contato.setTelefone(this.viewFornecedor.getJtfTelefone().getText().equals(Mensagem.mascaraTelefone) ? null : this.viewFornecedor.getJtfTelefone().getText());
        contatoController.salvar(contato);
        return contato;
    }

    public Endereco salvaEndereco(Endereco endereco) {
        EnderecoController enderecoController = new EnderecoController();
        endereco.setCidadeIdCidade(listaCidades.get(this.viewFornecedor.getJcbCidade().getSelectedIndex() - 1));
        endereco.setBairro(this.viewFornecedor.getJtfBairro().getText());
        endereco.setCep(this.viewFornecedor.getJtfCep().getText());
        endereco.setLogradouro(this.viewFornecedor.getJtfEndereco().getText());
        endereco.setNumero(Integer.parseInt(this.viewFornecedor.getJtfNumero().getText()));
        endereco.setComplemento(this.viewFornecedor.getJtfComplemento().getText().equals(Mensagem.vazio) ? null : this.viewFornecedor.getJtfComplemento().getText());
        enderecoController.salvar(endereco);
        return endereco;
    }

    public boolean validaSalvar() {

        if (Valida.vazio(this.viewFornecedor.getJtfCnpj().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCnpj);
            this.viewFornecedor.getJtfCnpj().setValue(null);
            this.viewFornecedor.getJtfCnpj().grabFocus();
            return false;
        }

        if (!Valida.cnpj(this.viewFornecedor.getJtfCnpj().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCnpjValido);
            this.viewFornecedor.getJtfCnpj().setText(null);
            this.viewFornecedor.getJtfCnpj().grabFocus();
            return false;
        }

        if (!Valida.vazio(this.viewFornecedor.getJtfInscricaoEstadual().getText())) {
            if (!Valida.ie(this.viewFornecedor.getJtfInscricaoEstadual().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaIeValido);
                this.viewFornecedor.getJtfInscricaoEstadual().setValue(null);
                this.viewFornecedor.getJtfInscricaoEstadual().grabFocus();
                return false;
            }
        }

        if (Valida.vazio(this.viewFornecedor.getJtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataFundacao);
            this.viewFornecedor.getJtfDataFundacao().setValue(null);
            this.viewFornecedor.getJtfDataFundacao().grabFocus();
            return false;
        }

        if (!Valida.data(this.viewFornecedor.getJtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewFornecedor.getJtfDataFundacao().setValue(null);
            this.viewFornecedor.getJtfDataFundacao().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFornecedor.getJtfRazaoSocial().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaRazaoSocial);
            this.viewFornecedor.getJtfRazaoSocial().setText(null);
            this.viewFornecedor.getJtfRazaoSocial().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFornecedor.getJtfEndereco().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEndereco);
            this.viewFornecedor.getJtfEndereco().setText(null);
            this.viewFornecedor.getJtfEndereco().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFornecedor.getJtfNumero().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNumero);
            this.viewFornecedor.getJtfNumero().setText(null);
            this.viewFornecedor.getJtfNumero().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFornecedor.getJtfBairro().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaBairro);
            this.viewFornecedor.getJtfBairro().setText(null);
            this.viewFornecedor.getJtfBairro().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewFornecedor.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCidade);
            return false;
        }

        if (Valida.vazio(this.viewFornecedor.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCep);
            this.viewFornecedor.getJtfCep().setValue(null);
            this.viewFornecedor.getJtfCep().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewFornecedor.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEstado);
            return false;
        }

        if (!Valida.vazio(this.viewFornecedor.getJtfEmail().getText())) {
            if (!Valida.email(this.viewFornecedor.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaEmailValido);
                this.viewFornecedor.getJtfEmail().setText(null);
                this.viewFornecedor.getJtfEmail().grabFocus();
                return false;
            }
        }

        if (Valida.vazio(this.viewFornecedor.getJtfContato().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaContato);
            this.viewFornecedor.getJtfContato().setText(null);
            this.viewFornecedor.getJtfContato().grabFocus();
            return false;
        }
        return true;
    }

    public void acaoBotaoNovo() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void liberarCampos() {
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(false);
        this.viewFornecedor.getJtfCnpj().grabFocus();
        this.viewFornecedor.getJtfCnpj().setEditable(true);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(true);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfEndereco().setEditable(true);
        this.viewFornecedor.getJtfComplemento().setEditable(true);
        this.viewFornecedor.getJtfNumero().setEditable(true);
        this.viewFornecedor.getJtfBairro().setEditable(true);
        this.viewFornecedor.getJcbCidade().setEnabled(true);
        this.viewFornecedor.getJcbEstado().setEnabled(true);
        this.viewFornecedor.getJtfTelefone().setEditable(true);
        this.viewFornecedor.getJtfDataFundacao().setEditable(true);
        this.viewFornecedor.getJtfEmail().setEditable(true);
        this.viewFornecedor.getJtfCelular().setEditable(true);
        this.viewFornecedor.getJtfCep().setEditable(true);
        this.viewFornecedor.getJtfContato().setEditable(true);
    }

    public void acaoBotaoCancelar() {
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void limparCampos() {
        this.viewFornecedor.getJtfCnpj().setValue(null);
        this.viewFornecedor.getJtfInscricaoEstadual().setValue(null);
        this.viewFornecedor.getJtfRazaoSocial().setText(null);
        this.viewFornecedor.getJtfEndereco().setText(null);
        this.viewFornecedor.getJtfComplemento().setText(null);
        this.viewFornecedor.getJtfNumero().setText(null);
        this.viewFornecedor.getJtfBairro().setText(null);
        this.viewFornecedor.getJcbCidade().setSelectedIndex(0);
        this.viewFornecedor.getJcbEstado().setSelectedIndex(0);
        this.viewFornecedor.getJtfTelefone().setValue(null);
        this.viewFornecedor.getJtfDataFundacao().setValue(null);
        this.viewFornecedor.getJtfEmail().setText(null);
        this.viewFornecedor.getJtfCelular().setValue(null);
        this.viewFornecedor.getJtfContato().setText(null);
        this.viewFornecedor.getJtfCep().setValue(null);
    }

    public void alterarFornecedor() {
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFornecedor);
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            this.viewFornecedor.getJtfCnpj().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getCnpj());
            this.viewFornecedor.getJtfInscricaoEstadual().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            this.viewFornecedor.getJtfRazaoSocial().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            this.viewFornecedor.getJtfDataFundacao().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            this.viewFornecedor.getJtfEndereco().setText(fornecedor.getEnderecoIdEndereco().getLogradouro());
            this.viewFornecedor.getJtfNumero().setText(fornecedor.getEnderecoIdEndereco().getNumero() + "");
            this.viewFornecedor.getJtfBairro().setText(fornecedor.getEnderecoIdEndereco().getBairro());
            this.viewFornecedor.getJtfComplemento().setText(fornecedor.getEnderecoIdEndereco().getComplemento());
            this.viewFornecedor.getJtfCep().setText(fornecedor.getEnderecoIdEndereco().getCep());
            this.viewFornecedor.getJcbCidade().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewFornecedor.getJcbEstado().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            this.viewFornecedor.getJtfEmail().setText(fornecedor.getContatoIdContato().getEmail());
            this.viewFornecedor.getJtfTelefone().setText(fornecedor.getContatoIdContato().getTelefone());
            this.viewFornecedor.getJtfCelular().setText(fornecedor.getContatoIdContato().getCelular());
            this.viewFornecedor.getJtfContato().setText(fornecedor.getContato());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void acaoBotaoAlterar() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
        this.viewFornecedor.getJtfEndereco().grabFocus();
    }

    public void bloqueioInicial() {
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfPesquisaRazaoSocial().grabFocus();
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(true);
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfEndereco().setEditable(false);
        this.viewFornecedor.getJtfNumero().setEditable(false);
        this.viewFornecedor.getJtfBairro().setEditable(false);
        this.viewFornecedor.getJcbCidade().setEnabled(false);
        this.viewFornecedor.getJcbEstado().setEnabled(false);
        this.viewFornecedor.getJtfTelefone().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
        this.viewFornecedor.getJtfCelular().setEditable(false);
        this.viewFornecedor.getJtfEmail().setEditable(false);
        this.viewFornecedor.getJtfCep().setEditable(false);
        this.viewFornecedor.getJtfComplemento().setEditable(false);
        this.viewFornecedor.getJtfContato().setEditable(false);
    }

    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarCidades();

        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFornecedor.getJcbCidade().removeAllItems();
        this.viewFornecedor.getJcbCidade().addItem(Mensagem.comboCidade);
        for (Cidade listaCidade : listaCidades) {
            this.viewFornecedor.getJcbCidade().addItem(listaCidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarEstados();

        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFornecedor.getJcbEstado().removeAllItems();
        this.viewFornecedor.getJcbEstado().addItem(Mensagem.comboEstado);
        for (Estado listaEstado : listaEstados) {
            this.viewFornecedor.getJcbEstado().addItem(listaEstado.getNome());
        }
    }

    public void listarFornecedores() {
        try {
            FornecedorDAO dao = new FornecedorDAO();
            listaFornecedores = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        modelo.setRowCount(0);
        for (Fornecedor listaFornecedor : listaFornecedores) {
            modelo.addRow(new String[]{listaFornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), listaFornecedor.getContatoIdContato().getTelefone(), listaFornecedor.getContato(), listaFornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome()});
        }
    }

    public ArrayList<Fornecedor> buscarFornecedores() throws Exception {
        FornecedorDAO dao = new FornecedorDAO();
        ArrayList<Fornecedor> listaFornecedores1 = dao.buscarTodos();
        return listaFornecedores1;
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
        logUsuario.setTabela(Mensagem.fornecedor);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
