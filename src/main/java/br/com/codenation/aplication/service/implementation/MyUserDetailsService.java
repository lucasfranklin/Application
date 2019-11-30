/*package br.com.codenation.aplication.service.implementation;

import br.com.codenation.aplication.domain.dao.EmpresaDAO;
import br.com.codenation.aplication.domain.dao.UsuarioDAO;
import br.com.codenation.aplication.domain.entity.Usuario;
import br.com.codenation.aplication.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<Usuario> usr = usuarioDAO.findByName(s);
        if(usr == null){
            throw new UsernameNotFoundException("Not Found!");
        }
        return  new UserRepositoryUserDetails(usr);
    }


    private final static class UserRepositoryUserDetails extends Usuario implements UserDetails {

        private static final long SerialVersionId = 1L;

        private UserRepositoryUserDetails(User user) {
            return super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities(){
            return getRoles();
        }

        @Override
        public String getPassword() {
            return this.getPassword();
        }

        @Override
        public String getUsername(){
            return this.getLogin();
        }

        @Override
        public boolean isAccountNonExpired(){
            return true;
        }

        @Override
        public boolean isAccountNonLocked(){
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}*/