package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOFormaPagamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFormaPagamento {

    public static void inserir(Connection c, TOFormaPagamento t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into formapagamento (descricao, metodo) values");
        s.append(" (?, ?)");
        Data.executeQuery(c,s.toString(),t.getDescricao(), t.getMetodo());
    }

    public static void editar(Connection c, TOFormaPagamento t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update formapagamento set descricao = ?, metodo = ? ");
        s.append(" where idformapagamento = ?");
        Data.executeQuery(c, s.toString(), t.getDescricao(), t.getIdFormaPagamento(), t.getIdFormaPagamento());
    }

    public static List<TOFormaPagamento> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idformapagamento, descricao, metodo from formapagamento");
        s.append(" order by descricao ");

        List<TOFormaPagamento> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOFormaPagamento u = new TOFormaPagamento();
                u.setDescricao(rs.getString("descricao"));
                u.setIdFormaPagamento(rs.getInt("idformapagamento"));
                u.setMetodo(rs.getString("metodo"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from formapagamento where idformapagamento = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
