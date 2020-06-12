package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ItemCompraDAO;
import br.com.foursys.vendas.model.ItemCompra;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ItemCompraController {

    public void salvar(ItemCompra itemCompra) {
        ItemCompraDAO dao = new ItemCompraDAO();
        dao.salvar(itemCompra);
    }

}
