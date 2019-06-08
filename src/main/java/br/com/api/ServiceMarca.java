package br.com.api;

import br.com.bo.BOMarca;
import br.com.to.TOMarca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("marca")
public class ServiceMarca {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOMarca u) throws Exception {

        BOMarca.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idmarca") int idmarca, TOMarca u) throws Exception {
        // colocar metodo que busca pelo id
        BOMarca.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOMarca> listar() throws Exception {
        return BOMarca.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idmarca") int idmarca) throws Exception {
        // colocar metodo que busca pelo id
        BOMarca.excluir(idmarca);
    }

}