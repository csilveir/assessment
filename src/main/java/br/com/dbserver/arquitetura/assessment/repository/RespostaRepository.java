package br.com.dbserver.arquitetura.assessment.repository;

import br.com.dbserver.arquitetura.assessment.model.Resposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Long> {


    public List<Resposta> findAll();


}