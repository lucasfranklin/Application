package br.com.codenation.aplication.controller;

import br.com.codenation.aplication.domain.entity.Usuario;
import br.com.codenation.aplication.service.UsuarioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    UsuarioImp usr;

    @GetMapping("/{userId}")
    public Optional<Usuario> findById(@PathVariable("userId") Long userId){

        return usr.findById(userId);

    }

    @GetMapping(params = {"accelerationName"})
    public List<Usuario> findByAccelerationName(@RequestParam("accelerationName")  String accelerationName) {
        return usr.findByName(accelerationName);
    }

    @GetMapping(params = {"companyId"})
    public List<Usuario> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return usr.findByCompanyId(companyId);
    }

}