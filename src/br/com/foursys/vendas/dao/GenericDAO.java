package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public abstract class GenericDAO {

    @SuppressWarnings("finally")

    public boolean salvar(Object object) {

        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.saveOrUpdate(object);
            transacao.commit();

        } catch (Exception e) {

            transacao.rollback();
            return false;
        } finally {
            sessao.close();
            return true;

        }

    }

    public void excluir(Object object) {

        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            sessao.delete(object);
            transacao.commit();

        } catch (Exception e) {

            transacao.rollback();

        } finally {
            sessao.close();
        }

    }

}
