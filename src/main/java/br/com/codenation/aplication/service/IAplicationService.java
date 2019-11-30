package br.com.codenation.aplication.service;

import java.math.BigDecimal;

public interface IAplicationService {

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario);

    public boolean createCompany(Long id, String name, String document, int vagas, String site);

    public void find(Long id, String name, String document, int age);

    public boolean checkCompany(String name, String document);

    public boolean checkUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario );

}
