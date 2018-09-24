package br.com.dbserver.arquitetura.assessment.repository;

import br.com.dbserver.arquitetura.assessment.model.Formulario;
import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import br.com.dbserver.arquitetura.assessment.model.PerguntaResposta;
import br.com.dbserver.arquitetura.assessment.model.Resposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRespostaRepository extends CrudRepository<PerguntaResposta, Long> {


    public Boolean existsByFormularioAndPergunta(final Formulario formulario, final Pergunta pergunta);

}