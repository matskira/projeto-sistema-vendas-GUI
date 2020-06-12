package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ItemCompra;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ItemCompraDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ItemCompra> buscarTodos() throws Exception {

        ArrayList<ItemCompra> listaRetorno = new ArrayList<ItemCompra>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(ItemCompra.class);

        criteria.addOrder(Order.asc("idItemCompra"));

        listaRetorno = (ArrayList<ItemCompra>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public ItemCompra buscarPorCodigo(int idItemCompra) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ItemCompra itemCompra = (ItemCompra) sessao.get(ItemCompra.class, idItemCompra);
        sessao.close();
        return itemCompra;
    }

}
