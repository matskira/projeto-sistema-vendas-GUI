package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.PessoaJuridicaDAO;
import br.com.foursys.vendas.model.PessoaJuridica;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class PessoaJuridicaController {

    public void salvar(PessoaJuridica pessoaJuridica) {
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        dao.salvar(pessoaJuridica);
    }

    public void excluir(PessoaJuridica pessoaJuridica) {
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        dao.excluir(pessoaJuridica);
    }
}
