package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class VendaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Venda> buscarTodos() throws Exception {

        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Venda.class);

        criteria.addOrder(Order.asc("idVenda"));

        listaRetorno = (ArrayList<Venda>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Venda buscarPorCodigo(int idVenda) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Venda venda = (Venda) sessao.get(Venda.class, idVenda);
        sessao.close();
        return venda;
    }

}
