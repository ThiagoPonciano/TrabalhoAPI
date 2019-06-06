package br.com.api;

import br.com.bo.BOCliente;
import br.com.to.TOCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

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




}
