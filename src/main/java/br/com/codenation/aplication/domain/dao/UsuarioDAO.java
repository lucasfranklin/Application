package br.com.codenation.aplication.domain.dao;

import br.com.codenation.aplication.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u.* FROM users u WHERE u.id = :userId",
            nativeQuery = true)
    Optional<Usuario> findById(@Param("userId") Long userId);

    @Query(value = "SELECT u.* FROM users u WHERE u.name = :name",
            nativeQuery = true)
    List<Usuario> findByName(@Param("name") String name);


    @Query(value = "SELECT u.* FROM users u WHERE u.company_id = :companyId", nativeQuery = true)
    List<Usuario> findByCompanyId(@Param("companyId") Long companyId);

}
