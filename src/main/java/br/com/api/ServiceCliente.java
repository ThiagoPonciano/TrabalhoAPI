package br.com.api;

import br.com.bo.BOCliente;
import br.com.to.TOCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("cliente")
public class ServiceCliente {

    @Context
    protected  HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOCliente u) throws Exception {

        BOCliente.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idcliente") int idcliente, TOCliente u) throws Exception {
        // colocar metodo que busca pelo id do cliente
            BOCliente.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOCliente> listar() throws Exception {
        return BOCliente.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idcliente") int idcliente) throws Exception {
        // colocar metodo que busca pelo id do cliente
            BOCliente.excluir(idcliente);
    }

}
