package br.com.codenation.aplication.service;

import br.com.codenation.aplication.domain.dao.UsuarioDAO;
import br.com.codenation.aplication.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

    @Service
    @AllArgsConstructor
    public class UsuarioImp implements IUsuario {

        @Autowired
        private UsuarioDAO userDAO;

        @Override
        public Optional<Usuario> findById(Long userId){
            return userDAO.findById(userId);
        }

        @Override
        public List<Usuario> findByName(String name){
            return userDAO.findByName(name);
        }

        @Override
        public List<Usuario> findByCompanyId(Long companyId){
            return userDAO.findByCompanyId(companyId);
        }

}
