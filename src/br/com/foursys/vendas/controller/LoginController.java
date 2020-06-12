package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.LoginPrincipal;
import br.com.foursys.vendas.view.MenuPrincipal;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class LoginController {

    private LoginPrincipal viewLogin;

    public LoginController(LoginPrincipal viewLogin) {
        this.viewLogin = viewLogin;
    }

    public void loginSistema() {
        if (this.viewLogin.getJtfLogin().getText().trim().equals(Mensagem.vazio)) {
            JOptionPane.showMessageDialog(null, Mensagem.informaLogin);
        } else {
            List<Funcionario> listaFuncionario = new FuncionarioController().buscarTodos(this.viewLogin.getJtfLogin().getText());
            int contLogin = 0;
            int contSenha = 0;
            for (Funcionario funcionario : listaFuncionario) {
                contLogin++;
                if (funcionario.getSenha().equals(this.viewLogin.getJtfSenha().getText())) {
                    this.viewLogin.dispose();
                    salvarTimeStamp(funcionario);
                    new MenuPrincipal(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
                } else {
                    contSenha++;
                }
            }
            if (contLogin == 0) {
                JOptionPane.showMessageDialog(null, Mensagem.loginInvalido);
            } else if (contSenha > 0) {
                JOptionPane.showMessageDialog(null, Mensagem.senhaInvalida);
            }

        }

    }

    public void salvarTimeStamp(Funcionario funcionario) {
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
        logUsuario.setOperacao("LOGIN");
        logUsuario.setTabela(null);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

}
