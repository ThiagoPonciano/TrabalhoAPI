package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOMarca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOMarca {

    public static void inserir(Connection c, TOMarca t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into marca (descricao) values");
        s.append(" (?)");
        Data.executeQuery(c,s.toString(),t.getDescricao());
    }

    public static void editar(Connection c, TOMarca t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update marca set descricao = ? ");
        s.append(" where idmarca = ?");
        Data.executeQuery(c, s.toString(), t.getDescricao(), t.getIdmarca());
    }

    public static List<TOMarca> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idmarca, descricao from marca");
        s.append(" order by descricao ");

        List<TOMarca> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOMarca u = new TOMarca();
                u.setDescricao(rs.getString("descricao"));
                u.setIdmarca(rs.getInt("idmarca"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from marca where idmarca = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
