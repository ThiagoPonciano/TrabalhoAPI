package br.com.dao;

import br.com.fw.Data;
import br.com.to.TOCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente {

    public static void inserir(Connection c, TOCliente t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" insert into cliente (nome, endereco) values");
        s.append(" (?, ?)");
        Data.executeQuery(c,s.toString(),t.getNome(), t.getEndereco());
    }

    public static void editar(Connection c, TOCliente t) throws Exception {
        StringBuilder s = new StringBuilder();
        s.append(" update cliente set nome = ?, endereco = ? ");
        s.append(" where idcliente = ?");
        Data.executeQuery(c, s.toString(), t.getNome(), t.getEndereco(), t.getIdcliente());
    }

    public static List<TOCliente> listar (Connection c) throws Exception {

        StringBuilder s = new StringBuilder();
        s.append(" select idcliente, nome, endereco from cliente");
        s.append(" order by nome ");

        List<TOCliente> l = new ArrayList<>();
        try (ResultSet rs = Data.executeQuery(c, s.toString())){

            while (rs.next()) {
                TOCliente u = new TOCliente();
                u.setNome(rs.getString("nome"));
                u.setIdcliente(rs.getInt("idcliente"));
                u.setEndereco(rs.getString("endereco"));
                l.add(u);
            }
        }
        return l;
    }

    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from cliente where idcliente = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
}
