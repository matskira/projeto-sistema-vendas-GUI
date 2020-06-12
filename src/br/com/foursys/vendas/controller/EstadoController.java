package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.EstadoDAO;
import br.com.foursys.vendas.model.Estado;
import java.util.ArrayList;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EstadoController {

    public ArrayList<Estado> buscarEstados() throws Exception {
        EstadoDAO dao = new EstadoDAO();
        ArrayList<Estado> listaEstados = dao.buscarTodos();
        return listaEstados;
    }
}
