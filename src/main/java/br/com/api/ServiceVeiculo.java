package br.com.api;

import br.com.bo.BOVeiculos;
import br.com.to.TOVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("veiculo")
public class ServiceVeiculo {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOVeiculo u) throws Exception {

        BOVeiculos.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idveiculo") int idveiculo, TOVeiculo u) throws Exception {
        // colocar metodo que busca pelo id
        BOVeiculos.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOVeiculo> listar() throws Exception {
        return BOVeiculos.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idveiculo") int idveiculo) throws Exception {
        // colocar metodo que busca pelo id
        BOVeiculos.excluir(idveiculo);
    }

}
