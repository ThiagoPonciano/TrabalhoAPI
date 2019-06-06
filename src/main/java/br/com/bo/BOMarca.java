package br.com.bo;

import br.com.dao.DAOMarca;
import br.com.fw.Data;
import br.com.to.TOMarca;

import java.sql.Connection;
import java.util.List;

public class BOMarca {

    public static void inserir(TOMarca t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOMarca.inserir(c, t);
        }
    }

    public static void editar(TOMarca t) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOMarca.editar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOMarca.excluir(c, id);
        }
    }

    public static List<TOMarca> listar() throws Exception{
        try(Connection c = Data.openConnection()){
            return DAOMarca.listar(c);
        }
    }

}
