/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.SobreEquipe;
import java.util.Calendar;

/**
 *
 * @author jgil
 */
public class SobreController {

    private SobreEquipe viewSobre;

    public SobreController(SobreEquipe viewSobre) {
        this.viewSobre = viewSobre;
    }

    public void salvarTimeStamp() {
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
        logUsuario.setOperacao(Mensagem.sobre);
        logUsuario.setTabela(null);
        logUsuario.setTimestamp(strData);

        controllerLogUsuario.salvar(logUsuario);
    }

}
