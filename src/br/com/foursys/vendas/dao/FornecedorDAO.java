package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class FornecedorDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Fornecedor> buscarTodos() throws Exception {

        ArrayList<Fornecedor> listaRetorno = new ArrayList<Fornecedor>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Fornecedor.class);

        criteria.addOrder(Order.asc("idFornecedor"));

        listaRetorno = (ArrayList<Fornecedor>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Fornecedor buscarPorCodigo(int idFornecedor) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Fornecedor fornecedor = (Fornecedor) sessao.get(Fornecedor.class, idFornecedor);
        sessao.close();
        return fornecedor;
    }

}
