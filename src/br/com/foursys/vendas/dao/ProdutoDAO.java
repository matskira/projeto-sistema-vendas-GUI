package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class ProdutoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Produto> buscarTodos(int fornecedorIdFornecedor) throws Exception {

        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Produto.class);
        criteria.add(Restrictions.ilike("fornecedorIdFornecedor", fornecedorIdFornecedor));
        criteria.addOrder(Order.asc("idProduto"));

        listaRetorno = (ArrayList<Produto>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    @SuppressWarnings("unchecked")
    public ArrayList<Produto> buscarTodos() throws Exception {

        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Produto.class);

        criteria.addOrder(Order.asc("idProduto"));

        listaRetorno = (ArrayList<Produto>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Produto buscarPorCodigo(int idProduto) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Produto produto = (Produto) sessao.get(Produto.class, idProduto);
        sessao.close();
        return produto;
    }

}
