package br.com.api;

import br.com.bo.BOFuncionario;
import br.com.to.TOFuncionario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("funcionario")
public class ServiceFuncionario {

    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public void inserir(TOFuncionario u) throws Exception {

        BOFuncionario.inserir(u);
        response.sendError(HttpServletResponse.SC_CREATED);

    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    public void editar(@HeaderParam("idfuncionario") int idfuncionario, TOFuncionario u) throws Exception {
        // colocar metodo que busca pelo id
        BOFuncionario.editar(u);
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public List<TOFuncionario> listar() throws Exception {
        return BOFuncionario.listar();
    }

    @DELETE
    @Path("excluir")
    @Produces("application/json;charset=utf-8")
    public void excluir(@HeaderParam("idfuncionario") int idfuncionario) throws Exception {
        // colocar metodo que busca pelo id
        BOFuncionario.excluir(idfuncionario);
    }

}
