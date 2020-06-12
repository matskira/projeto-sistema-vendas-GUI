package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ContasPagarDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ContasPagar> buscarTodos() throws Exception {

        ArrayList<ContasPagar> listaRetorno = new ArrayList<ContasPagar>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(ContasPagar.class);

        criteria.addOrder(Order.asc("idContasPagar"));

        listaRetorno = (ArrayList<ContasPagar>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public ContasPagar buscarPorCodigo(int idContasPagar) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ContasPagar contasPagar = (ContasPagar) sessao.get(ContasPagar.class, idContasPagar);
        sessao.close();
        return contasPagar;
    }

}
