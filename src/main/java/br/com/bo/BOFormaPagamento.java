package br.com.bo;

import br.com.dao.DAOFormaPagamento;
import br.com.fw.Data;
import br.com.to.TOFormaPagamento;

import java.sql.Connection;
import java.util.List;

public class BOFormaPagamento {

    public static void inserir(TOFormaPagamento t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFormaPagamento.inserir(c, t);
        }
    }

    public static void editar(TOFormaPagamento t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFormaPagamento.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOFormaPagamento.excluir(c, id);
        }
    }

    public static List<TOFormaPagamento> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOFormaPagamento.listar(c);
        }
    }
}
