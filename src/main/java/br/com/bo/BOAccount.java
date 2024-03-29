package br.com.bo;

import br.com.dao.DAOAccount;
import br.com.fw.*;
import br.com.to.TOAccount;

import java.sql.Connection;
import java.util.List;

public class BOAccount {


    public static boolean isValid(String token) throws Exception {
        try (Connection c = Data.openConnection()) {
            TOAccount a = DAOAccount.getByToken(c, token);
            if (a != null) {

                DateTime now = DateTime.now();
                if (a.getExpiredAt().getTime() > now.getMillis()) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }

    public static TOAccount me(String token) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOAccount.getByToken(c, token);
        }
    }

    public static List<TOAccount> accounts() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOAccount.accounts(c);
        }
    }


    public static void editar(TOAccount u) throws Exception {
        try(Connection c = Data.openConnection()){
            u.setPassword(Encrypt.sha1(u.getPassword()));
            DAOAccount.editar(c, u);
        }
    }

    public static TOAccount insert(TOAccount u) throws Exception {
        try(Connection c = Data.openConnection()){
            u.setId(Guid.getString());
            u.setPassword(Encrypt.sha1(u.getPassword()));
            DAOAccount.insert(c, u);



            return u;
        }
    }

    public static TOAccount auth(TOAccount u) throws Exception {

        try (Connection c = Data.openConnection()) {

            u.setPassword(Encrypt.sha1(u.getPassword()));

            TOAccount t = DAOAccount.auth(c, u);
            if (t != null) {

                DateTime expiredAt = DateTime.now();
                expiredAt.addMinute(5);

                t.setExpiredAt(expiredAt.getTimestamp());

                t.setToken(Guid.getString());
                DAOAccount.updateToken(c, t);
            }

            return t;
        }

    }

    public static void excluir(int id) throws Exception {
        try(Connection c = Data.openConnection()){
            DAOAccount.excluir(c, id);
        }
    }

}

