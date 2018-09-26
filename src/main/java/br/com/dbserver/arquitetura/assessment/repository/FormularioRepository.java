package br.com.dbserver.arquitetura.assessment.repository;

import br.com.dbserver.arquitetura.assessment.model.Formulario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends CrudRepository<Formulario, Long> {


    boolean existsByTimeAndSprint(final String time, final Integer sprint);

}