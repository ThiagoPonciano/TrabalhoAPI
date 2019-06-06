package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOLocacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOLocacao {

    public static void inserir(Connection c, TOLocacao t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into locacao (descricao) values");
        s.append(" (?, ?)");
        Data.executeQuery(c,s.toString(),t.getDescricao());
    }

    public static void editar(Connection c, TOLocacao t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update locacao set descricao = ? ");
        s.append(" where idlocacao = ?");
        Data.executeQuery(c, s.toString(), t.getDescricao(), t.getIdlocacao());
    }

    public static List<TOLocacao> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idlocacao, descricao from locacao");
        s.append(" order by descricao ");

        List<TOLocacao> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOLocacao u = new TOLocacao();
                u.setDescricao(rs.getString("descricao"));
                u.setIdlocacao(rs.getInt("idlocacao"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from locacao where idlocacao = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
