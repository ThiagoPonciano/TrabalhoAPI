package br.com.bo;

import br.com.dao.DAOFuncionario;
import br.com.fw.Data;
import br.com.to.TOFuncionario;

import java.sql.Connection;
import java.util.List;

public class BOFuncionario {
    public static void inserir(TOFuncionario t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFuncionario.inserir(c, t);
        }
    }

    public static void editar(TOFuncionario t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFuncionario.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFuncionario.excluir(c, id);
        }
    }

    public static List<TOFuncionario> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOFuncionario.listar(c);
        }
    }

}
