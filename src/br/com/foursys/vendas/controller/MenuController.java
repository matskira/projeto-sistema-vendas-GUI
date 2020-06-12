package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.MenuPrincipal;
import java.awt.Menu;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class MenuController {

    private static MenuPrincipal viewMenu;
    private Menu menu = new Menu();

    public MenuController(MenuPrincipal viewMenu) {
        this.viewMenu = viewMenu;
    }

    public void acaoBotaoSair() {
        int x = JOptionPane.showConfirmDialog(null, Mensagem.sairSistema, Mensagem.atencao,
                JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            LogUsuarioController controllerLogUsuario = new LogUsuarioController();
            Funcionario func1 = controllerLogUsuario.buscaFuncionario();
            salvarTimeStamp(func1, Mensagem.sairDoSistema);
            System.exit(0);
        }

    }

    public void bloqueiaTudo() {
        this.viewMenu.getJbtCliente().setEnabled(false);
        this.viewMenu.getJbtFornecedor().setEnabled(false);
        this.viewMenu.getJbtVendas().setEnabled(false);
        this.viewMenu.getJbtCompras().setEnabled(false);
        this.viewMenu.getJbtFuncionarios().setEnabled(false);
        this.viewMenu.getJbtProdutos().setEnabled(false);
        this.viewMenu.getJbtSair().setEnabled(false);

        this.viewMenu.getJmCadastro().setEnabled(false);
        this.viewMenu.getJmEstoque().setEnabled(false);
        this.viewMenu.getJmVendas().setEnabled(false);
        this.viewMenu.getJmCompras().setEnabled(false);
        this.viewMenu.getJmSistema().setEnabled(false);
    }

    public static void desbloqueiaTudo() {

        MenuController.viewMenu.getJbtCliente().setEnabled(true);
        MenuController.viewMenu.getJbtFornecedor().setEnabled(true);
        MenuController.viewMenu.getJbtVendas().setEnabled(true);
        MenuController.viewMenu.getJbtCompras().setEnabled(true);
        MenuController.viewMenu.getJbtFuncionarios().setEnabled(true);
        MenuController.viewMenu.getJbtProdutos().setEnabled(true);
        MenuController.viewMenu.getJbtSair().setEnabled(true);

        MenuController.viewMenu.getJmCadastro().setEnabled(true);
        MenuController.viewMenu.getJmEstoque().setEnabled(true);
        MenuController.viewMenu.getJmVendas().setEnabled(true);
        MenuController.viewMenu.getJmCompras().setEnabled(true);
        MenuController.viewMenu.getJmSistema().setEnabled(true);

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
        logUsuario.setTabela(null);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }
    
    public void acaoBotaoLogout() {
        LogUsuarioController controllerLogUsuario = new LogUsuarioController();
        Funcionario func1 = controllerLogUsuario.buscaFuncionario();
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
        logUsuario.setFuncionarioIdFuncionario(func1);
        logUsuario.setOperacao(Mensagem.logout);
        logUsuario.setTabela(null);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

}
