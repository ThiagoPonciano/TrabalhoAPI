package br.com.api;

import javax.ws.rs.core.Application;
import java.util.Set;


@javax.ws.rs.ApplicationPath("locadora")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(ServiceAccount.class);
        resources.add(ServiceCliente.class);
        resources.add(ServiceFormaPagamento.class);
        resources.add(ServiceFuncionario.class);
        resources.add(ServiceLocacao.class);
        resources.add(ServiceMarca.class);
        resources.add(ServiceModelo.class);
        resources.add(ServiceVeiculo.class);

    }

}
