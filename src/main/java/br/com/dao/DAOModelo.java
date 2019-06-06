package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOModelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOModelo {

    public static void inserir(Connection c, TOModelo t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into modelo (descricao) values");
        s.append(" (?)");
        Data.executeQuery(c,s.toString(),t.getDescricao());
    }

    public static void editar(Connection c, TOModelo t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update modelo set descricao = ? ");
        s.append(" where idmodelo = ?");
        Data.executeQuery(c, s.toString(), t.getDescricao(), t.getIdmodelo());
    }

    public static List<TOModelo> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idmodelo, descricao from modelo");
        s.append(" order by descricao ");

        List<TOModelo> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOModelo u = new TOModelo();
                u.setDescricao(rs.getString("descricao"));
                u.setIdmodelo(rs.getInt("idmodelo"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from modelo where idmodelo = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
