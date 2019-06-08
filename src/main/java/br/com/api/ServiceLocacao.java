package br.com.api;

import br.com.bo.BOLocacao;
import br.com.to.TOLocacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("locacao")
public class ServiceLocacao {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOLocacao u) throws Exception {

        BOLocacao.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idlocacao") int idlocacao, TOLocacao u) throws Exception {
        // colocar metodo que busca pelo id
        BOLocacao.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOLocacao> listar() throws Exception {
        return BOLocacao.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idlocacao") int idlocacao) throws Exception {
        // colocar metodo que busca pelo id
        BOLocacao.excluir(idlocacao);
    }

}
