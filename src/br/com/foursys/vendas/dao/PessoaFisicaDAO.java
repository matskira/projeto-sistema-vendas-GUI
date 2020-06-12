package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class PessoaFisicaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<PessoaFisica> buscarTodos() throws Exception {

        ArrayList<PessoaFisica> listaRetorno = new ArrayList<PessoaFisica>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(PessoaFisica.class);

        criteria.addOrder(Order.asc("idPessoaFisica"));

        listaRetorno = (ArrayList<PessoaFisica>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public PessoaFisica buscarPorCodigo(int idPessoaFisica) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        PessoaFisica pessoaFisica = (PessoaFisica) sessao.get(PessoaFisica.class, idPessoaFisica);
        sessao.close();
        return pessoaFisica;
    }

}
