/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class FuncionarioDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos() throws Exception {

        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Funcionario.class);

        criteria.addOrder(Order.asc("idFuncionario"));

        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos(String login) throws Exception {

        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("idFuncionario"));

        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;

    }

    public Funcionario buscarPorCodigo(int idFuncionario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario funcionario = (Funcionario) sessao.get(Funcionario.class, idFuncionario);
        sessao.close();
        return funcionario;
    }

}
