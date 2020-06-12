package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.PessoaFisicaDAO;
import br.com.foursys.vendas.model.PessoaFisica;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class PessoaFisicaController {

    public void salvar(PessoaFisica pessoaFisica) {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        dao.salvar(pessoaFisica);
    }

    public void excluir(PessoaFisica pessoaFisica) {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        dao.excluir(pessoaFisica);
    }
}
