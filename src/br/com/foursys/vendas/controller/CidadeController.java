package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.CidadeDAO;
import br.com.foursys.vendas.model.Cidade;
import java.util.ArrayList;

/**
* @author's: Equipe 4 "Diego, we have a problem!"
 */
public class CidadeController {

    public ArrayList<Cidade> buscarCidades() throws Exception {
        CidadeDAO dao = new CidadeDAO();
        ArrayList<Cidade> listaCidades = dao.buscarTodos();
        return listaCidades;
    }
}
