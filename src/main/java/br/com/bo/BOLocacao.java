package br.com.bo;

import br.com.dao.DAOLocacao;
import br.com.fw.Data;
import br.com.to.TOLocacao;

import java.sql.Connection;
import java.util.List;

public class BOLocacao {

    public static void inserir(TOLocacao t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOLocacao.inserir(c, t);
        }
    }

    public static void editar(TOLocacao t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOLocacao.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOLocacao.excluir(c, id);
        }
    }

    public static List<TOLocacao> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOLocacao.listar(c);
        }
    }

}
