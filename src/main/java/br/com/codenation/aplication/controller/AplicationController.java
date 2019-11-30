package br.com.codenation.aplication.controller;
import br.com.codenation.aplication.service.implementation.AplicationService;

import java.math.BigDecimal;

public class AplicationController {

    AplicationService app = new AplicationService();

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario){
        return app.createUser(id, name, document, age, login, password, compId, salario);
    }

    public boolean createCompany(Long id, String name, String document, int vagas, String site) {
        return app.createCompany(id, name, document, vagas, site);
    }

    public void find(Long id, String name, String document, int age){
        app.find(id, name, document, age);
    }

}
