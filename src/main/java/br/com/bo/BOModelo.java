package br.com.bo;

import br.com.dao.DAOModelo;
import br.com.fw.Data;
import br.com.to.TOModelo;

import java.sql.Connection;
import java.util.List;

public class BOModelo {

    public static void inserir(TOModelo t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOModelo.inserir(c, t);
        }
    }

    public static void editar(TOModelo t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOModelo.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOModelo.excluir(c, id);
        }
    }

    public static List<TOModelo> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOModelo.listar(c);
        }
    }
}
