package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.EnderecoDAO;
import br.com.foursys.vendas.model.Endereco;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class EnderecoController {
    public void salvar(Endereco endereco) {
        EnderecoDAO dao = new EnderecoDAO();
        dao.salvar(endereco);
    }
    
    public void excluir(Endereco endereco) {
        EnderecoDAO dao = new EnderecoDAO();
        dao.excluir(endereco);
    }
}
