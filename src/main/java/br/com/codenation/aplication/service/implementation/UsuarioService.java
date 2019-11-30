package br.com.codenation.aplication.service.implementation;

import br.com.codenation.aplication.Exceptions.CodenationException;
import br.com.codenation.aplication.domain.dao.EmpresaDAO;
import br.com.codenation.aplication.domain.dao.UsuarioDAO;
import br.com.codenation.aplication.domain.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService  {

    Logger LOG = LoggerFactory.getLogger(AplicationService.class);

    private List<Usuario> users = new ArrayList<>();

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario) throws CodenationException {

        //empresas.stream().filter(comp -> comp.getId().equals(compId))

        if(checkUser(id, name, document, age, login, password, compId, salario)) {
           /* Usuario user = new Usuario();
            user.setId(id);
            user.setDocumento(document);
            user.setIdade(age);
            user.setNome(name);
            user.setLogin(login);
            user.setSenha(password);
            user.setSalario(salario);
            //user.setEmpresaId(compId);


            users.add(user);
*/
           /* empresas.stream().filter(emp ->
                    emp.getId().equals(compId) && emp.countList() < emp.getVagas()).findFirst().orElse(null).addUser(user);
*/
        }
        return true;
    }

    public boolean checkUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario ){
        if(id == null || name.isEmpty() || document.isEmpty() || age < 0 || login.isEmpty() || password.isEmpty()){
            LOG.info("ERRO - TODOS OS CAMPOS SAO OBRIGATORIOS E PRECISAM SER VALIDOS!{}", name.isEmpty());
            throw new CodenationException("Campos Obrigatorios.");
        }

        else if(users.stream().filter(usr -> usr.getNome().equals(login)).findFirst().isPresent()){

            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE NOME!");
            throw new CodenationException("Usuario ja existente.");
        }

        else if(users.stream().filter(usr -> usr.getDocumento().equals(document)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE DOCUMENTO!");
            throw new CodenationException("JA EXISTE USUARIO COM ESSE DOCUMENTO.");
        }

        else if(users.stream().filter(usr -> usr.getNome().equals(name)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE NOME!");
            throw new CodenationException("JA EXISTE USUARIO COM ESSE NOME.");
        }

        return true;
    }


}
