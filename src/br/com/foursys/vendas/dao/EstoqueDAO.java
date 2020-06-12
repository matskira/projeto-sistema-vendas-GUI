package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EstoqueDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Estoque> buscarTodos() throws Exception {

        ArrayList<Estoque> listaRetorno = new ArrayList<Estoque>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Estoque.class);

        criteria.addOrder(Order.asc("idEstoque"));

        listaRetorno = (ArrayList<Estoque>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Estoque buscarPorCodigo(int idEstoque) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Estoque estoque = (Estoque) sessao.get(Estoque.class, idEstoque);
        sessao.close();
        return estoque;
    }

}
