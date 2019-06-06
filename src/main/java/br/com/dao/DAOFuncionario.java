package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOFuncionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario {
    public static void inserir(Connection c, TOFuncionario t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into funcionario (nome, endereco) values");
        s.append(" (?, ?)");
        Data.executeQuery(c,s.toString(),t.getNome(), t.getEndereco());
    }

    public static void editar(Connection c, TOFuncionario t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update funcionario set nome = ?, endereco = ? ");
        s.append(" where idfuncionario = ?");
        Data.executeQuery(c, s.toString(), t.getNome(), t.getEndereco(), t.getIdfuncionario());
    }

    public static List<TOFuncionario> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idfuncionario, nome, endereco from funcionario");
        s.append(" order by nome ");

        List<TOFuncionario> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOFuncionario u = new TOFuncionario();
                u.setNome(rs.getString("nome"));
                u.setIdfuncionario(rs.getInt("idfuncionario"));
                u.setEndereco(rs.getString("endereco"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from funcionario where idfuncionario = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
