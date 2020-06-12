package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ClienteDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Cliente;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ClientePrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ClienteController {

    private ClientePrincipal viewCliente;
    Cliente cliente = new Cliente();
    ArrayList<Cliente> listaClientes;
    ArrayList<Estado> listaEstados;
    ArrayList<Cidade> listaCidades;
    private boolean alterar;

    public ClienteController() {
    }

    public ClienteController(ClientePrincipal viewCliente) {
        this.viewCliente = viewCliente;
    }

    public void excluirCliente() {
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaCliente);
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExcluir, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ClienteDAO dao = new ClienteDAO();
                try {
                    dao.excluir(cliente);
                    LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                    Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                    salvarTimeStamp(func1, Mensagem.excluir);
                    new ContatoController().excluir(cliente.getContatoIdContato());
                    new EnderecoController().excluir(cliente.getEnderecoIdEndereco());
                    if (cliente.getTipoPessoa().equals(Mensagem.pessoaFisica)) {
                        new PessoaFisicaController().excluir(cliente.getPessoaFisicaIdPessoaFisica());
                    } else {
                        new PessoaJuridicaController().excluir(cliente.getPessoaJuridicaIdPessoaJuridica());
                    }
                    JOptionPane.showMessageDialog(null, Mensagem.clienteExcluido);
                    listarClientes();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.erroExcluirCliente);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void listarClientes() {
        try {
            ClienteDAO dao = new ClienteDAO();
            listaClientes = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        modelo.setRowCount(0);
        for (Cliente listaCliente : listaClientes) {
            if (listaCliente.getTipoPessoa().equals(Mensagem.pessoaFisica)) {
                modelo.addRow(new String[]{listaCliente.getPessoaFisicaIdPessoaFisica().getNome(), listaCliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), listaCliente.getContatoIdContato().getCelular(), listaCliente.getContatoIdContato().getEmail()});
            } else {
                modelo.addRow(new String[]{listaCliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), listaCliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), listaCliente.getContatoIdContato().getCelular(), listaCliente.getContatoIdContato().getEmail()});
            }
        }
    }

    public void acaoBotaoSalvar() {
        if (validaSalvar()) {
            ClienteDAO dao = new ClienteDAO();
            Contato contato = new Contato();
            Endereco endereco = new Endereco();
            if (!this.alterar) {
                cliente = new Cliente();
                if (this.viewCliente.getJrbFisico().isSelected()) {
                    PessoaFisicaController pessoaFisicaController = new PessoaFisicaController();
                    PessoaFisica pessoaFisica = new PessoaFisica();
                    pessoaFisica.setCpf(this.viewCliente.getJtfCpf().getText());
                    pessoaFisica.setDataNascimento(this.viewCliente.getJtfDataNascimento().getText());
                    pessoaFisica.setNome(this.viewCliente.getJtfNome().getText());
                    pessoaFisica.setRg(this.viewCliente.getJtfRg().getText());
                    pessoaFisicaController.salvar(pessoaFisica);
                    cliente.setPessoaFisicaIdPessoaFisica(pessoaFisica);
                    cliente.setTipoPessoa(Mensagem.pessoaFisica);
                    LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                    Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                    salvarTimeStamp(func1, Mensagem.salvar);
                } else {
                    PessoaJuridica pessoaJuridica = new PessoaJuridica();
                    PessoaJuridicaController pessoaJuridicaController = new PessoaJuridicaController();
                    pessoaJuridica.setCnpj(this.viewCliente.getJtfCpf().getText());
                    pessoaJuridica.setDataFundacao(this.viewCliente.getJtfDataNascimento().getText());
                    pessoaJuridica.setRazaoSocial(this.viewCliente.getJtfNome().getText());
                    pessoaJuridica.setInscricaoEstadual(this.viewCliente.getJtfRg().getText().equals(Mensagem.mascaraIeSalva) ? null : this.viewCliente.getJtfRg().getText());
                    pessoaJuridicaController.salvar(pessoaJuridica);
                    cliente.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);
                    cliente.setTipoPessoa(Mensagem.pessoaJuridica);
                }
            } else {
                contato = cliente.getContatoIdContato();
                endereco = cliente.getEnderecoIdEndereco();
                LogUsuarioController controllerLogUsuario = new LogUsuarioController();
                Funcionario func1 = controllerLogUsuario.buscaFuncionario();
                salvarTimeStamp(func1, Mensagem.alterar);
            }
            contato = salvaContato(contato);
            endereco = salvaEndereco(endereco);
            cliente.setContatoIdContato(contato);
            cliente.setEnderecoIdEndereco(endereco);
            dao.salvar(cliente);
            JOptionPane.showMessageDialog(null, Mensagem.clienteSalvo);
            limparCampos();
            bloqueioInicial();
            listarClientes();
        }
    }

    public Contato salvaContato(Contato contato) {
        ContatoController contatoController = new ContatoController();
        contato.setCelular(this.viewCliente.getJtfCelular().getText().equals(Mensagem.mascaraCelular) ? null : this.viewCliente.getJtfCelular().getText());
        contato.setEmail(this.viewCliente.getJtfEmail().getText().equals(Mensagem.vazio) ? null : this.viewCliente.getJtfEmail().getText());
        contato.setTelefone(this.viewCliente.getJtfTelefone().getText().equals(Mensagem.mascaraTelefone) ? null : this.viewCliente.getJtfTelefone().getText());
        contatoController.salvar(contato);
        return contato;
    }

    public Endereco salvaEndereco(Endereco endereco) {
        EnderecoController enderecoController = new EnderecoController();
        endereco.setCidadeIdCidade(buscaCidade(this.viewCliente.getJcbCidade().getSelectedItem().toString()));
        endereco.setBairro(this.viewCliente.getJtfBairro().getText());
        endereco.setCep(this.viewCliente.getJtfCep().getText());
        endereco.setLogradouro(this.viewCliente.getJtfEndereco().getText());
        endereco.setNumero(Integer.parseInt(this.viewCliente.getJtfNumero().getText()));
        endereco.setComplemento(this.viewCliente.getJtfComplemento().getText().equals(Mensagem.vazio) ? null : this.viewCliente.getJtfComplemento().getText());
        enderecoController.salvar(endereco);
        return endereco;
    }

    public void alterarCliente() {
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.selecionaCliente);
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            if (cliente.getTipoPessoa().equals(Mensagem.pessoaFisica)) {
                this.viewCliente.getJrbFisico().setSelected(true);
                mascaraCpf();
                mascaraRg();
                mascaraFisica();
                this.viewCliente.getJtfCpf().setText(cliente.getPessoaFisicaIdPessoaFisica().getCpf());
                this.viewCliente.getJtfRg().setText(cliente.getPessoaFisicaIdPessoaFisica().getRg());
                this.viewCliente.getJtfNome().setText(cliente.getPessoaFisicaIdPessoaFisica().getNome());
                this.viewCliente.getJtfDataNascimento().setText(cliente.getPessoaFisicaIdPessoaFisica().getDataNascimento());
            } else {
                this.viewCliente.getJrbJuridico().setSelected(true);
                mascaraCnpj();
                mascaraInscricaoEstadual();
                mascaraJuridica();
                this.viewCliente.getJtfCpf().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getCnpj());
                this.viewCliente.getJtfRg().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
                this.viewCliente.getJtfNome().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
                this.viewCliente.getJtfDataNascimento().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            }

            this.viewCliente.getJtfEndereco().setText(cliente.getEnderecoIdEndereco().getLogradouro());
            this.viewCliente.getJtfNumero().setText(cliente.getEnderecoIdEndereco().getNumero() + "");
            this.viewCliente.getJtfBairro().setText(cliente.getEnderecoIdEndereco().getBairro());
            this.viewCliente.getJtfComplemento().setText(cliente.getEnderecoIdEndereco().getComplemento());
            this.viewCliente.getJtfCep().setText(cliente.getEnderecoIdEndereco().getCep());
            this.viewCliente.getJcbCidade().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewCliente.getJcbEstado().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            this.viewCliente.getJtfTelefone().setText(cliente.getContatoIdContato().getTelefone());
            this.viewCliente.getJtfCelular().setText(cliente.getContatoIdContato().getCelular());
            this.viewCliente.getJtfEmail().setText(cliente.getContatoIdContato().getEmail());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void acaoBotaoAlterar() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewCliente.getJrbFisico().setEnabled(false);
        this.viewCliente.getJrbJuridico().setEnabled(false);
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
        this.viewCliente.getJtfEndereco().grabFocus();
    }

    public Cidade buscaCidade(String cidade) {
        Cidade city = new Cidade();
        for (Cidade listaCidade : listaCidades) {
            if (listaCidade.getNome().equals(cidade)) {
                city = listaCidade;
                return city;
            }
        }
        return city;
    }

    public boolean validaSalvar() {
        if (this.viewCliente.getJrbFisico().isSelected()) {
            if (Valida.vazio(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaCpf);
                this.viewCliente.getJtfCpf().setValue(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            }

            if (!Valida.cpf(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaCpfValido);
                this.viewCliente.getJtfCpf().setText(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            }

            if (Valida.vazio(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaRg);
                this.viewCliente.getJtfRg().setValue(null);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            }

            if (!Valida.rg(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaRgValido);
                this.viewCliente.getJtfRg().setValue(null);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            }

            if (Valida.vazio(this.viewCliente.getJtfNome().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaNome);
                this.viewCliente.getJtfNome().setText(null);
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            }

            if (!Valida.nome(this.viewCliente.getJtfNome().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaNomeValido);
                this.viewCliente.getJtfNome().setText(null);
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            }

            if (Valida.vazio(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaDataNascimento);
                this.viewCliente.getJtfDataNascimento().setValue(null);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            }

        } else if (this.viewCliente.getJrbJuridico().isSelected()) {
            if (Valida.vazio(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaCnpj);
                this.viewCliente.getJtfCpf().setText(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            }

            if (!Valida.cnpj(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaCnpjValido);
                this.viewCliente.getJtfCpf().setText(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            }

            if (!Valida.vazio(this.viewCliente.getJtfRg().getText())) {
                if (!Valida.ie(this.viewCliente.getJtfRg().getText())) {
                    JOptionPane.showMessageDialog(null, Mensagem.informaIeValido);
                    this.viewCliente.getJtfRg().setValue(null);
                    this.viewCliente.getJtfRg().grabFocus();
                    return false;
                }
            }

            if (Valida.vazio(this.viewCliente.getJtfNome().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaRazaoSocial);
                this.viewCliente.getJtfNome().setText(null);
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            }

            if (Valida.vazio(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaDataFundacao);
                this.viewCliente.getJtfDataNascimento().setValue(null);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(null, Mensagem.informaTipoPessoa);
            return false;
        }

        if (!Valida.data(this.viewCliente.getJtfDataNascimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaDataValida);
            this.viewCliente.getJtfDataNascimento().setValue(null);
            this.viewCliente.getJtfDataNascimento().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewCliente.getJtfEndereco().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEndereco);
            this.viewCliente.getJtfEndereco().setText(null);
            this.viewCliente.getJtfEndereco().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewCliente.getJtfNumero().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNumero);
            this.viewCliente.getJtfNumero().setText(null);
            this.viewCliente.getJtfNumero().grabFocus();
            return false;
        }

        if (!Valida.numero(this.viewCliente.getJtfNumero().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaNumeroValido);
            this.viewCliente.getJtfNumero().setText(null);
            this.viewCliente.getJtfNumero().grabFocus();
            return false;
        }

        if (Valida.vazio(this.viewCliente.getJtfBairro().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaBairro);
            this.viewCliente.getJtfBairro().setText(null);
            this.viewCliente.getJtfBairro().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewCliente.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCidade);
            return false;
        }

        if (Valida.vazio(this.viewCliente.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaCep);
            this.viewCliente.getJtfCep().setValue(null);
            this.viewCliente.getJtfCep().grabFocus();
            return false;
        }

        if (Valida.testaZero(this.viewCliente.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.informaEstado);
            return false;
        }

        if (!Valida.vazio(this.viewCliente.getJtfEmail().getText())) {
            if (!Valida.email(this.viewCliente.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.informaEmailValido);
                this.viewCliente.getJtfEmail().setText(null);
                this.viewCliente.getJtfEmail().grabFocus();
                return false;
            }
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewCliente.getJtfPesquisarNome().setEditable(true);
        this.viewCliente.getJtfPesquisarNome().grabFocus();
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
        this.viewCliente.getJtfEndereco().setEditable(false);
        this.viewCliente.getJtfNumero().setEditable(false);
        this.viewCliente.getJtfBairro().setEditable(false);
        this.viewCliente.getJcbCidade().setEnabled(false);
        this.viewCliente.getJcbEstado().setEnabled(false);
        this.viewCliente.getJtfTelefone().setEditable(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
        this.viewCliente.getJtfCelular().setEditable(false);
        this.viewCliente.getJtfEmail().setEditable(false);
        this.viewCliente.getJtfCep().setEditable(false);
        this.viewCliente.getJrbFisico().setEnabled(false);
        this.viewCliente.getJrbJuridico().setEnabled(false);
        this.viewCliente.getJtfComplemento().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void liberarCampos() {
        this.viewCliente.getJtfPesquisarNome().setEditable(false);
        this.viewCliente.getJtfCpf().grabFocus();
        this.viewCliente.getJtfCpf().setEditable(true);
        this.viewCliente.getJtfRg().setEditable(true);
        this.viewCliente.getJtfNome().setEditable(true);
        this.viewCliente.getJtfEndereco().setEditable(true);
        this.viewCliente.getJtfNumero().setEditable(true);
        this.viewCliente.getJtfBairro().setEditable(true);
        this.viewCliente.getJcbCidade().setEnabled(true);
        this.viewCliente.getJcbEstado().setEnabled(true);
        this.viewCliente.getJtfTelefone().setEditable(true);
        this.viewCliente.getJtfDataNascimento().setEditable(true);
        this.viewCliente.getJtfCelular().setEditable(true);
        this.viewCliente.getJtfEmail().setEditable(true);
        this.viewCliente.getJtfCep().setEditable(true);
        this.viewCliente.getJrbFisico().setEnabled(true);
        this.viewCliente.getJrbJuridico().setEnabled(true);
        this.viewCliente.getJtfComplemento().setEditable(true);
    }

    public void acaoBotaoCancelar() {
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void limparCampos() {
        this.viewCliente.getJtfCpf().setValue(null);
        this.viewCliente.getJtfRg().setValue(null);
        this.viewCliente.getJtfNome().setText(null);
        this.viewCliente.getJtfEndereco().setText(null);
        this.viewCliente.getJtfNumero().setText(null);
        this.viewCliente.getJtfBairro().setText(null);
        this.viewCliente.getJcbCidade().setSelectedIndex(0);
        this.viewCliente.getJcbEstado().setSelectedIndex(0);
        this.viewCliente.getJtfTelefone().setValue(null);
        this.viewCliente.getJtfDataNascimento().setValue(null);
        this.viewCliente.getJtfCelular().setValue(null);
        this.viewCliente.getJtfEmail().setText(null);
        this.viewCliente.getJtfCep().setValue(null);
        this.viewCliente.getJtfComplemento().setText(null);
        this.viewCliente.getButtonGroup1().clearSelection();
    }

    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarCidades();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCliente.getJcbCidade().removeAllItems();
        this.viewCliente.getJcbCidade().addItem(Mensagem.comboCidade);
        for (Cidade listaCidade : listaCidades) {

            this.viewCliente.getJcbCidade().addItem(listaCidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarEstados();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCliente.getJcbEstado().removeAllItems();
        this.viewCliente.getJcbEstado().addItem(Mensagem.comboEstado);
        for (Estado listaEstado : listaEstados) {
            this.viewCliente.getJcbEstado().addItem(listaEstado.getNome());
        }
    }

    public void mascaraCnpj() {
        try {
            this.viewCliente.getJtfCpf().setValue(null);
            MaskFormatter cnpj = new MaskFormatter(Mensagem.mascaraCnpj);
            this.viewCliente.getJtfCpf().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
            this.viewCliente.getJlbCpf().setText(Mensagem.cnpj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraCpf() {
        try {
            this.viewCliente.getJtfCpf().setValue(null);
            MaskFormatter cnpj = new MaskFormatter(Mensagem.mascaraCpf);
            this.viewCliente.getJtfCpf().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
            this.viewCliente.getJlbCpf().setText(Mensagem.cpf);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraInscricaoEstadual() {

        try {
            this.viewCliente.getJtfRg().setValue(null);
            MaskFormatter cnpj = new MaskFormatter(Mensagem.mascaraIe);
            this.viewCliente.getJtfRg().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
            this.viewCliente.getJlbRg().setText(Mensagem.ie);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraRg() {

        try {
            this.viewCliente.getJtfRg().setValue(null);
            MaskFormatter cnpj = new MaskFormatter(Mensagem.mascaraRg);
            this.viewCliente.getJtfRg().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
            this.viewCliente.getJlbRg().setText(Mensagem.rg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraFisica() {
        this.viewCliente.getJlbNome().setText(Mensagem.nome);
        this.viewCliente.getJtfNome().setText(null);
        this.viewCliente.getJlbDataNascimento().setText(Mensagem.dataNascimento);
        this.viewCliente.getJtfDataNascimento().setText(null);
    }

    public void mascaraJuridica() {
        this.viewCliente.getJlbNome().setText(Mensagem.razaoSocial);
        this.viewCliente.getJlbDataNascimento().setText(Mensagem.dataFundacao);
    }

    public ArrayList<Cliente> buscarTodos() throws Exception {
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> listaClientes = dao.buscarTodos();
        return listaClientes;
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
