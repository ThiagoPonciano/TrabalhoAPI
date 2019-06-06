package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOVeiculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOVeiculos {

    public static void inserir(Connection c, TOVeiculo t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into veiculo (nome) values");
        s.append(" (?)");
        Data.executeQuery(c,s.toString(),t.getNome());
    }

    public static void editar(Connection c, TOVeiculo t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update veiculo set nome = ? ");
        s.append(" where idveiculo = ?");
        Data.executeQuery(c, s.toString(), t.getNome(), t.getIdveiculo());
    }

    public static List<TOVeiculo> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idveiculo, nome from veiculo");
        s.append(" order by nome ");

        List<TOVeiculo> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOVeiculo u = new TOVeiculo();
                u.setNome(rs.getString("nome"));
                u.setIdveiculo(rs.getInt("idveiculo"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from veiculo where idveiculo = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
