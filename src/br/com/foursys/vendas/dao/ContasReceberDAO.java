package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ContasReceberDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ContasReceber> buscarTodos() throws Exception {

        ArrayList<ContasReceber> listaRetorno = new ArrayList<ContasReceber>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(ContasReceber.class);

        criteria.addOrder(Order.asc("idContasReceber"));

        listaRetorno = (ArrayList<ContasReceber>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public ContasReceber buscarPorCodigo(int idContasReceber) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ContasReceber contasReceber = (ContasReceber) sessao.get(ContasReceber.class, idContasReceber);
        sessao.close();
        return contasReceber;
    }

}
