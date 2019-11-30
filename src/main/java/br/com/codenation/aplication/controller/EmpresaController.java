package br.com.codenation.aplication.controller;


import br.com.codenation.aplication.domain.dao.EmpresaDAO;
import br.com.codenation.aplication.domain.entity.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    private EmpresaDAO repository;

    EmpresaController(EmpresaDAO repository) {
        this.repository = repository;
    }

    @GetMapping("/vi/save")
    ResponseEntity save(@RequestBody Empresa emp){
        repository.saver(emp);
        return ResponseEntity.ok().build();
    }


}
