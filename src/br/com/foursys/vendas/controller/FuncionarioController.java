package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.FuncionarioDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.FuncionarioPrincipal;
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
public class FuncionarioController {

    private FuncionarioPrincipal viewFuncionario;
    Funcionario funcionario = new Funcionario();
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Cidade> listaCidades;
    private ArrayList<Estado> listaEstados;
    private boolean alterar;

    public FuncionarioController(FuncionarioPrincipal viewFuncionario) {
        this.viewFuncionario = viewFuncionario;
    }

    public FuncionarioController() {
    }

    public void excluirFuncionario() {
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFuncionario);
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                FuncionarioDAO dao = new FuncionarioDAO();
                try {
                    dao.excluir(funcionario);
                    LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                    Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                    salvarTimeStamp(func1, "EXCLUIR");
                    new ContatoController().excluir(funcionario.getContatoIdContato());
                    new EnderecoController().excluir(funcionario.getEnderecoIdEndereco());
                    new PessoaFisicaController().excluir(funcionario.getPessoaFisicaIdPessoaFisica());

                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioExcluido);
                    listarFuncionarios();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroExcluirFuncionario);
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Funcionario> buscarFuncionarios() throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> listaFuncionarios1 = dao.buscarTodos();
        return listaFuncionarios1;
    }

    public void alterarFuncionario() {
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaFuncionario);
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            this.viewFuncionario.getJtfCpf().setText(funcionario.getPessoaFisicaIdPessoaFisica().getCpf());
            this.viewFuncionario.getJtfRg().setText(funcionario.getPessoaFisicaIdPessoaFisica().getRg());
            this.viewFuncionario.getJtfNome().setText(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
            this.viewFuncionario.getJtfDataNascimento().setText(funcionario.getPessoaFisicaIdPessoaFisica().getDataNascimento());
            this.viewFuncionario.getJtfEndereco().setText(funcionario.getEnderecoIdEndereco().getLogradouro());
            this.viewFuncionario.getJtfNumero().setText(funcionario.getEnderecoIdEndereco().getNumero() + "");
            this.viewFuncionario.getJtfBairro().setText(funcionario.getEnderecoIdEndereco().getBairro());
            this.viewFuncionario.getJtfComplemento().setText(funcionario.getEnderecoIdEndereco().getComplemento());
            this.viewFuncionario.getJtfCep().setText(funcionario.getEnderecoIdEndereco().getCep());
            this.viewFuncionario.getJcbCidade().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewFuncionario.getJcbEstado().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            this.viewFuncionario.getJtfEmail().setText(funcionario.getContatoIdContato().getEmail());
            this.viewFuncionario.getJtfTelefone().setText(funcionario.getContatoIdContato().getTelefone());
            this.viewFuncionario.getJtfCelular().setText(funcionario.getContatoIdContato().getCelular());
            this.viewFuncionario.getJtfLogin().setText(funcionario.getLogin());
            this.viewFuncionario.getJtfSenha().setText(funcionario.getSenha());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void acaoBotaoAlterar() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
        this.viewFuncionario.getJtfEndereco().grabFocus();
    }

    public void acaoBotaoSalvar() {
        if (validaSalvar()) {
            FuncionarioDAO dao = new FuncionarioDAO();
            Contato contato = new Contato();
            Endereco endereco = new Endereco();
            if (!this.alterar) {
                funcionario = new Funcionario();
                PessoaFisicaController pessoaFisicaController = new PessoaFisicaController();
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setCpf(this.viewFuncionario.getJtfCpf().getText());
                pessoaFisica.setDataNascimento(this.viewFuncionario.getJtfDataNascimento().getText());
                pessoaFisica.setNome(this.viewFuncionario.getJtfNome().getText());
                pessoaFisica.setRg(this.viewFuncionario.getJtfRg().getText());
                pessoaFisicaController.salvar(pessoaFisica);
                funcionario.setPessoaFisicaIdPessoaFisica(pessoaFisica);
            } else {
                contato = funcionario.getContatoIdContato();
                endereco = funcionario.getEnderecoIdEndereco();
            }
            contato = salvaContato(contato);
            endereco = salvaEndereco(endereco);
            funcionario.setLogin(this.viewFuncionario.getJtfLogin().getText());
            funcionario.setSenha(this.viewFuncionario.getJtfSenha().getText());
            funcionario.setContatoIdContato(contato);
            funcionario.setEnderecoIdEndereco(endereco);
            dao.salvar(funcionario);
            LogUsuarioController controllerLogUsuario = new LogUsuarioController();
            Funcionario func1 = controllerLogUsuario.buscaFuncionario();
            salvarTimeStamp(func1, "SALVAR");
            JOptionPane.showMessageDialog(null, Mensagem.funcionarioSalvo);
            limparCampos();
            bloqueioInicial();
            listarFuncionarios();
        }
    } // fim do método acaoBotaoSalvar

    public Contato salvaContato(Contato contato) {
        ContatoController contatoController = new ContatoController();
        contato.setCelular(this.viewFuncionario.getJtfCelular().getText().equals(Mensagem.mascaraCelular) ? null : this.viewFuncionario.getJtfCelular().getText());
        contato.setEmail(this.viewFuncionario.getJtfEmail().getText().equals(Mensagem.vazio) ? null : this.viewFuncionario.getJtfEmail().getText());
        contato.setTelefone(this.viewFuncionario.getJtfTelefone().getText().equals(Mensagem.mascaraTelefone) ? null : this.viewFuncionario.getJtfTelefone().getText());
        contatoController.salvar(contato);
        return contato;
    }

    public Endereco salvaEndereco(Endereco endereco) {
        EnderecoController enderecoController = new EnderecoController();
        endereco.setCidadeIdCidade(listaCidades.get(this.viewFuncionario.getJcbCidade().getSelectedIndex() - 1));
        endereco.setBairro(this.viewFuncionario.getJtfBairro().getText());
        endereco.setCep(this.viewFuncionario.getJtfCep().getText());
        endereco.setLogradouro(this.viewFuncionario.getJtfEndereco().getText());
        endereco.setNumero(Integer.parseInt(this.viewFuncionario.getJtfNumero().getText()));
        endereco.setComplemento(this.viewFuncionario.getJtfComplemento().getText().equals(Mensagem.vazio) ? null : this.viewFuncionario.getJtfComplemento().getText());
        enderecoController.salvar(endereco);
        return endereco;
    }

    public boolean validaSalvar() {
        if (Valida.vazio(this.viewFuncionario.getJtfCpf().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCpf);
            this.viewFuncionario.getJtfCpf().setValue(null);
            this.viewFuncionario.getJtfCpf().grabFocus();
            return false;
        }

        if (!Valida.cpf(this.viewFuncionario.getJtfCpf().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCpfValido);
            this.viewFuncionario.getJtfCpf().setText(null);
            this.viewFuncionario.getJtfCpf().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfRg().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaRg);
            this.viewFuncionario.getJtfRg().setValue(null);
            this.viewFuncionario.getJtfRg().grabFocus();
            return false;
        }

        if (!Valida.rg(this.viewFuncionario.getJtfRg().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaRgValido);
            this.viewFuncionario.getJtfRg().setValue(null);
            this.viewFuncionario.getJtfRg().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfDataNascimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataNascimento);
            this.viewFuncionario.getJtfDataNascimento().setValue(null);
            this.viewFuncionario.getJtfDataNascimento().grabFocus();
            return false;
        }

        if (!Valida.data(this.viewFuncionario.getJtfDataNascimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewFuncionario.getJtfDataNascimento().setValue(null);
            this.viewFuncionario.getJtfDataNascimento().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfNome().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNome);
            this.viewFuncionario.getJtfNome().setText(null);
            this.viewFuncionario.getJtfNome().grabFocus();
            return false;
        }

        if (Valida.nome(this.viewFuncionario.getJtfNome().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNomeValido);
            this.viewFuncionario.getJtfNome().setText(null);
            this.viewFuncionario.getJtfNome().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfEndereco().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEndereco);
            this.viewFuncionario.getJtfEndereco().setText(null);
            this.viewFuncionario.getJtfEndereco().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfNumero().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNumero);
            this.viewFuncionario.getJtfNumero().setText(null);
            this.viewFuncionario.getJtfNumero().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfBairro().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaBairro);
            this.viewFuncionario.getJtfBairro().setText(null);
            this.viewFuncionario.getJtfBairro().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewFuncionario.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCidade);
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCep);
            this.viewFuncionario.getJtfCep().setValue(null);
            this.viewFuncionario.getJtfCep().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewFuncionario.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEstado);
            return false;
        }

        if (!Valida.vazio(this.viewFuncionario.getJtfEmail().getText())) {
            if (!Valida.email(this.viewFuncionario.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaEmailValido);
                this.viewFuncionario.getJtfEmail().setText(null);
                this.viewFuncionario.getJtfEmail().grabFocus();
                return false;
            }
        }

        if (Valida.vazio(this.viewFuncionario.getJtfLogin().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaLogin);
            this.viewFuncionario.getJtfLogin().setText(null);
            this.viewFuncionario.getJtfLogin().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewFuncionario.getJtfSenha().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaSenha);
            this.viewFuncionario.getJtfSenha().setText(null);
            this.viewFuncionario.getJtfSenha().grabFocus();
            return false;
        }
        return true;
    }

    public void acaoBotaoCancelar() {
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void limparCampos() {
        this.viewFuncionario.getJtfCpf().setValue(null);
        this.viewFuncionario.getJtfRg().setValue(null);
        this.viewFuncionario.getJtfNome().setText(null);
        this.viewFuncionario.getJtfEndereco().setText(null);
        this.viewFuncionario.getJtfComplemento().setText(null);
        this.viewFuncionario.getJtfNumero().setText(null);
        this.viewFuncionario.getJtfBairro().setText(null);
        this.viewFuncionario.getJcbCidade().setSelectedIndex(0);
        this.viewFuncionario.getJcbEstado().setSelectedIndex(0);
        this.viewFuncionario.getJtfTelefone().setValue(null);
        this.viewFuncionario.getJtfDataNascimento().setValue(null);
        this.viewFuncionario.getJtfEmail().setText(null);
        this.viewFuncionario.getJtfCelular().setValue(null);
        this.viewFuncionario.getJtfLogin().setText(null);
        this.viewFuncionario.getJtfSenha().setText(null);
        this.viewFuncionario.getJtfCep().setValue(null);
    }

    public void acaoBotaoNovo() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void liberarCampos() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(false);
        this.viewFuncionario.getJtfCpf().grabFocus();
        this.viewFuncionario.getJtfCpf().setEditable(true);
        this.viewFuncionario.getJtfRg().setEditable(true);
        this.viewFuncionario.getJtfNome().setEditable(true);
        this.viewFuncionario.getJtfEndereco().setEditable(true);
        this.viewFuncionario.getJtfComplemento().setEditable(true);
        this.viewFuncionario.getJtfNumero().setEditable(true);
        this.viewFuncionario.getJtfBairro().setEditable(true);
        this.viewFuncionario.getJcbCidade().setEnabled(true);
        this.viewFuncionario.getJcbEstado().setEnabled(true);
        this.viewFuncionario.getJtfTelefone().setEditable(true);
        this.viewFuncionario.getJtfDataNascimento().setEditable(true);
        this.viewFuncionario.getJtfEmail().setEditable(true);
        this.viewFuncionario.getJtfCelular().setEditable(true);
        this.viewFuncionario.getJtfLogin().setEditable(true);
        this.viewFuncionario.getJtfCep().setEditable(true);
        this.viewFuncionario.getJtfSenha().setEditable(true);
    }

    public void bloqueioInicial() {
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(true);
        this.viewFuncionario.getJtfPesquisarNome().grabFocus();
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
        this.viewFuncionario.getJtfEndereco().setEditable(false);
        this.viewFuncionario.getJtfComplemento().setEditable(false);
        this.viewFuncionario.getJtfNumero().setEditable(false);
        this.viewFuncionario.getJtfBairro().setEditable(false);
        this.viewFuncionario.getJcbCidade().setEnabled(false);
        this.viewFuncionario.getJtfCep().setEditable(false);
        this.viewFuncionario.getJcbEstado().setEnabled(false);
        this.viewFuncionario.getJtfEmail().setEditable(false);
        this.viewFuncionario.getJtfTelefone().setEditable(false);
        this.viewFuncionario.getJtfCelular().setEditable(false);
        this.viewFuncionario.getJtfLogin().setEditable(false);
        this.viewFuncionario.getJtfSenha().setEditable(false);
    }

    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarCidades();

        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFuncionario.getJcbCidade().removeAllItems();
        this.viewFuncionario.getJcbCidade().addItem(Mensagem.comboCidade);
        for (Cidade listaCidade : listaCidades) {
            this.viewFuncionario.getJcbCidade().addItem(listaCidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarEstados();

        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFuncionario.getJcbEstado().removeAllItems();
        this.viewFuncionario.getJcbEstado().addItem(Mensagem.comboEstado);
        for (Estado listaEstado : listaEstados) {
            this.viewFuncionario.getJcbEstado().addItem(listaEstado.getNome());
        }
    }

    public void listarFuncionarios() {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            listaFuncionarios = dao.buscarTodos();
            carregarTabela();

        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        modelo.setRowCount(0);
        for (Funcionario listaFuncionario : listaFuncionarios) {
            modelo.addRow(new String[]{listaFuncionario.getPessoaFisicaIdPessoaFisica().getNome(), listaFuncionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), listaFuncionario.getContatoIdContato().getTelefone(), listaFuncionario.getContatoIdContato().getCelular()});
        }
    }

    public List<Funcionario> buscarTodos(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionarios = null;
        try {
            listaFuncionarios = dao.buscarTodos(login);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionarios;
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
        logUsuario.setTabela(Mensagem.cliente);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
}
