package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class CompraDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Compra> buscarTodos() throws Exception {

        ArrayList<Compra> listaRetorno = new ArrayList<Compra>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Compra.class);

        criteria.addOrder(Order.asc("idCompra"));

        listaRetorno = (ArrayList<Compra>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Compra buscarPorCodigo(int idCompra) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Compra compra = (Compra) sessao.get(Compra.class, idCompra);
        sessao.close();
        return compra;
    }

}
