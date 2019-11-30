package br.com.codenation.aplication.service.implementation;

import br.com.codenation.aplication.Exceptions.CodenationException;
import br.com.codenation.aplication.domain.dao.EmpresaDAO;
import br.com.codenation.aplication.domain.entity.Empresa;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmpresaService {

    Logger LOG = LoggerFactory.getLogger(AplicationService.class);

    private List<Empresa> empresas = new ArrayList<>();

    @Autowired
    EmpresaDAO companyDao;


    @Transactional
    public boolean createCompany(Long id, String name, String document, int vagas, String site){

        if(checkCompany(name, document)) {
            Empresa company = new Empresa();
            company.setId(id);
            company.setNome(name);
            company.setDocumento(document);
            company.setVagas(vagas);
            company.setSite(site);

            companyDao.saver(company);

        }
        return true;
    }

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
}
