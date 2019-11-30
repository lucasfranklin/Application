package br.com.codenation.aplication.service;

import br.com.codenation.aplication.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuario {

    Optional<Usuario> findById(Long userId);

    List<Usuario> findByName(String name);

    List<Usuario> findByCompanyId(Long companyId);


}
