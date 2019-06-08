package br.com.api;

import br.com.bo.BOFormaPagamento;
import br.com.to.TOFormaPagamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("formapagamento")
public class ServiceFormaPagamento {

    @Context
    protected  HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOFormaPagamento u) throws Exception {

        BOFormaPagamento.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idformapagamento") int idformapagamento, TOFormaPagamento u) throws Exception {
        // colocar metodo que busca pelo id
        BOFormaPagamento.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOFormaPagamento> listar() throws Exception {
        return BOFormaPagamento.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idformapagamento") int idformapagamento) throws Exception {
        // colocar metodo que busca pelo id
        BOFormaPagamento.excluir(idformapagamento);
    }

}