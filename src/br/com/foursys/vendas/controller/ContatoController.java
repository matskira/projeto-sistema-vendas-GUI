package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContatoDAO;
import br.com.foursys.vendas.model.Contato;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ContatoController {
    
    public void salvar(Contato contato) {
        ContatoDAO dao = new ContatoDAO();
        dao.salvar(contato);
    }
    
    public void excluir(Contato contato) {
        ContatoDAO dao = new ContatoDAO();
        dao.excluir(contato);
    }
}
