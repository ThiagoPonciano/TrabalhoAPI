package br.com.bo;

import br.com.dao.DAOCliente;
import br.com.fw.Data;
import br.com.to.TOCliente;

import java.sql.Connection;
import java.util.List;

public class BOCliente {

    public static void inserir(TOCliente t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOCliente.inserir(c, t);
        }
    }

    public static void editar(TOCliente t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOCliente.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOCliente.excluir(c, id);
        }
    }

    public static List<TOCliente> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOCliente.listar(c);
        }
    }


}
