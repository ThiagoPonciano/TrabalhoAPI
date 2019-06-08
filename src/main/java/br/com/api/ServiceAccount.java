package br.com.api;

import br.com.bo.BOAccount;
import br.com.to.TOAccount;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("account")
public class ServiceAccount {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Path("auth")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public TOAccount auth(TOAccount u) throws Exception {

        TOAccount t = BOAccount.auth(u);

        if (t == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        return t;

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("token") String token, TOAccount u) throws Exception {
        if (BOAccount.isValid(token)) {
            BOAccount.editar(u);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }


    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public String inserir(TOAccount u) throws Exception {
        TOAccount t = BOAccount.insert(u);
        JSONObject j = new JSONObject();
        j.put("id", t.getId());

        response.sendError(HttpServletResponse.SC_CREATED);

        return j.toString();
    }


    @GET
    @Path("me")
    @Produces("application/json;charset=utf-8")
    public TOAccount me(@HeaderParam("token") String token) throws Exception {

        if (BOAccount.isValid(token)) {
            return BOAccount.me(token);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }

    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOAccount> listar() throws Exception {
        return BOAccount.accounts();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("token") String token, @HeaderParam("idaccount") int idaccount) throws Exception {
        if(BOAccount.isValid(token)){
            BOAccount.excluir(idaccount);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

}
