package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.LogUsuario;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class LogUsuarioDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<LogUsuario> buscarTodos() throws Exception {

        ArrayList<LogUsuario> listaRetorno = new ArrayList<LogUsuario>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(LogUsuario.class);

        criteria.addOrder(Order.asc("idLogUsuario"));

        listaRetorno = (ArrayList<LogUsuario>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public LogUsuario buscarPorCodigo(int idLogUsuario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        LogUsuario logUsuario = (LogUsuario) sessao.get(LogUsuario.class, idLogUsuario);
        sessao.close();
        return logUsuario;
    }

}
