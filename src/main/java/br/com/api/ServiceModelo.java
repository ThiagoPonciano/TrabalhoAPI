package br.com.api;

import br.com.bo.BOModelo;
import br.com.to.TOModelo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("modelo")
public class ServiceModelo {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOModelo u) throws Exception {

        BOModelo.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idmodelo") int idmodelo, TOModelo u) throws Exception {
        // colocar metodo que busca pelo id
        BOModelo.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOModelo> listar() throws Exception {
        return BOModelo.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idmodelo") int idmodelo) throws Exception {
        // colocar metodo que busca pelo id
        BOModelo.excluir(idmodelo);
    }

}
