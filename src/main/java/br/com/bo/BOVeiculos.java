package br.com.bo;

import br.com.dao.DAOVeiculos;
import br.com.fw.Data;
import br.com.to.TOVeiculo;

import java.sql.Connection;
import java.util.List;

public class BOVeiculos {

    public static void inserir(TOVeiculo t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOVeiculos.inserir(c, t);
        }
    }

    public static void editar(TOVeiculo t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOVeiculos.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOVeiculos.excluir(c, id);
        }
    }

    public static List<TOVeiculo> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOVeiculos.listar(c);
        }
    }

}
