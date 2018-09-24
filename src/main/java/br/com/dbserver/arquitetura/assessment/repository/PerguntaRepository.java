package br.com.dbserver.arquitetura.assessment.repository;

import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends CrudRepository<Pergunta, Long> {


    public List<Pergunta> findAll();


}