package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.LogUsuarioDAO;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.LogUsuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class LogUsuarioController {

    public void salvar(LogUsuario logUsuario) {
        LogUsuarioDAO dao = new LogUsuarioDAO();
        dao.salvar(logUsuario);
    }
    
    public Funcionario buscaFuncionario() {
            ArrayList<LogUsuario> aux = new ArrayList<LogUsuario>();
            Funcionario funcionario = new Funcionario();
        try {
            aux = buscarLogUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (LogUsuario aux1 : aux) {
                funcionario = aux1.getFuncionarioIdFuncionario();
            }
        return funcionario;
    }
    
    public ArrayList<LogUsuario> buscarLogUsuarios() throws Exception {
        LogUsuarioDAO dao = new LogUsuarioDAO();
        ArrayList<LogUsuario> listaLogUsuarios = dao.buscarTodos();
        return listaLogUsuarios;
    }
}
