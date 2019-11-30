package br.com.codenation.aplication.service.implementation;
import br.com.codenation.aplication.domain.entity.Empresa;
import br.com.codenation.aplication.domain.entity.Usuario;
import br.com.codenation.aplication.service.IAplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.codenation.aplication.Exceptions.CodenationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AplicationService implements IAplicationService {

    Logger LOG = LoggerFactory.getLogger(AplicationService.class);

    private List<Usuario> users = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId, BigDecimal salario) throws CodenationException{

        //empresas.stream().filter(comp -> comp.getId().equals(compId))

        if(checkUser(id, name, document, age, login, password, compId, salario)) {
        /*    Usuario user = new Usuario();
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
            //empresas.stream().filter(emp ->
            //        emp.getId().equals(compId) && emp.countList() < emp.getVagas()).findFirst().orElse(null).addUser(user);

        }
        return true;
    }

    public boolean createCompany(Long id, String name, String document, int vagas, String site){

        if(checkCompany(name, document)) {
            Empresa company = new Empresa();
            company.setId(id);
            company.setNome(name);
            company.setDocumento(document);
            company.setVagas(vagas);
            company.setSite(site);

            empresas.add(company);

        }
        return true;
    }

    public void find(Long id, String name, String document, int age){
        empresas.forEach(item->{
            if(id == (item.getId())){
                item.getUsers().forEach(item2->{
                    if(name == item2.getNome() && document == item2.getDocumento() && age == item2.getIdade()){
                        System.out.println("Usuario: " + item2.getNome() + " - Empresa: " + item.getNome());
                    }}
                );
            }
        });
    }

    void printAllUsers(){
        for (Usuario us: users
             ) {
            System.out.println(us.getSenha());
        }
    }

    void printAllCompanys(){
        empresas.forEach(item->{
            System.out.println(item.getNome());
        });
    }

    String cryptoPassword(String password){

        password = password.replace("u", "#0P");
        password = password.replace("s", "[%0");
        password = password.replace("e", "lD7");
        password = password.replace("r", "çA=");

        return password;
    }

    void printBiggetsSalaryByCompany(){
//        for (Empresa emp:
//             empresas) {
//
//            System.out.println(users.stream().filter(u -> u.getEmpresaId().equals(emp.getId()))
//                    .max(Comparator.comparing(Usuario::getSalario)));
//        }

    }

    /*
    void printMediaSalarial(){
        BigDecimal sum;
        for (Empresa emp:
                empresas) {

            sum = users
                    .stream()
                    .map(Usuario::getSalario)
                    .reduce(BigDecimal::add)
                    .get();

            BigDecimal result = empresas.stream()
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

        }
    }*/

    public boolean checkCompany(String name, String document){
        if(empresas.stream().filter(comp -> comp.getNome().equals(name)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE EMPRESA COM ESSE NOME!");
            throw new CodenationException("JA EXISTE EMPRESA COM ESSE NOME.");
        }
        else if(empresas.stream().filter(comp -> comp.getDocumento().equals(document)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE EMPRESA COM ESSE DOCUMENTO!");
            throw new CodenationException("JA EXISTE EMPRESA COM ESSE DOCUMENTO.");
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
