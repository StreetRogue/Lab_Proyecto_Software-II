package co.edu.unicauca.usermicroservices.repositories;

import co.edu.unicauca.usermicroservices.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
}
