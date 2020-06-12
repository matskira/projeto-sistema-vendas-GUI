package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ItemVendaDAO;
import br.com.foursys.vendas.model.ItemVenda;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ItemVendaController {

    public void salvar(ItemVenda itemVenda) {
        ItemVendaDAO dao = new ItemVendaDAO();
        dao.salvar(itemVenda);
    }

}
