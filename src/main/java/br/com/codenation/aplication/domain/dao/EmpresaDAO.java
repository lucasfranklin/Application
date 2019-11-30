package br.com.codenation.aplication.domain.dao;

import br.com.codenation.aplication.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaDAO extends JpaRepository<Empresa, Long> {

    public void saver(Empresa emp);

    public void delete();

}
