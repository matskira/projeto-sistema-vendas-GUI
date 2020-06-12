package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EnderecoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Endereco> buscarTodos() throws Exception {

        ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Endereco.class);

        criteria.addOrder(Order.asc("idEndereco"));

        listaRetorno = (ArrayList<Endereco>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Endereco buscarPorCodigo(int idEndereco) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Endereco endereco = (Endereco) sessao.get(Endereco.class, idEndereco);
        sessao.close();
        return endereco;
    }

}
