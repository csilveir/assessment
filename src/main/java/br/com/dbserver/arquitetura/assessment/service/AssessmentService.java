package br.com.dbserver.arquitetura.assessment.service;

import br.com.dbserver.arquitetura.assessment.dto.RespostaFormulario;
import br.com.dbserver.arquitetura.assessment.model.Formulario;
import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import br.com.dbserver.arquitetura.assessment.model.PerguntaResposta;
import br.com.dbserver.arquitetura.assessment.model.Resposta;
import br.com.dbserver.arquitetura.assessment.repository.FormularioRepository;
import br.com.dbserver.arquitetura.assessment.repository.PerguntaRepository;
import br.com.dbserver.arquitetura.assessment.repository.PerguntaRespostaRepository;
import br.com.dbserver.arquitetura.assessment.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AssessmentService {


    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private FormularioRepository formularioRepository;

    public PerguntaRespostaRepository getPerguntaRespostaRepository() {
        return perguntaRespostaRepository;
    }

    @Autowired
    private PerguntaRespostaRepository perguntaRespostaRepository;

    public PerguntaRepository getPerguntaRepository() {
        return perguntaRepository;
    }

    public FormularioRepository getFormularioRepository() {
        return formularioRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;


    public List<Pergunta> loadAllPerguntas() {
        var all = perguntaRepository.findAll();
        all.sort(Comparator.comparing(Pergunta::getId));

        return all;
    }

    public List<Resposta> loadAllRespostas() {

        var all = respostaRepository.findAll();
        all.sort(Comparator.comparing(Resposta::getId));
        return all;
    }

    public Formulario salvarFormulario(final RespostaFormulario respostaFormulario) {

        Formulario formulario = null;


        if (Objects.isNull(respostaFormulario.getId())) {

            if (formularioRepository.existsByTimeAndSprint(respostaFormulario.getTime(), respostaFormulario.getSprint())) {

                throw new RuntimeException(String.format("Avaliação do time %s na sprint %d já foi efetuada!", respostaFormulario.getTime(), respostaFormulario.getSprint()));
            }

            formulario = fromTransport(respostaFormulario);


        } else {
            Optional<Formulario> formularioById = formularioRepository.findById(respostaFormulario.getId());
            formularioById.orElseThrow(() -> new RuntimeException("Inválido formulário"));
            formulario = formularioById.get();

            validaEdicoesAvaliacoesAntigas(formulario);
        }


        return inserirResposta(respostaFormulario, formulario);


    }

    private Formulario fromTransport(RespostaFormulario respostaFormulario) {
        Formulario formulario;
        formulario = new Formulario();
        respostaFormulario.setDtAvaliacao(new Date());
        formulario.setTime(respostaFormulario.getTime());
        formulario.setDtAvaliacao(respostaFormulario.getDtAvaliacao());
        formulario.setSprint(respostaFormulario.getSprint());
        formulario = formularioRepository.save(formulario);
        return formulario;
    }

    private void validaEdicoesAvaliacoesAntigas(Formulario save) {
        if (Objects.nonNull(save.getDtAvaliacao())) {
            long diff = new Date().getTime() - save.getDtAvaliacao().getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 1) {
                throw new RuntimeException("Não é possível editar avaliações antigas.");
            }

        }
    }

    private Formulario inserirResposta(RespostaFormulario respostaFormulario, Formulario formulario) {


        formulario = formularioRepository.findById(formulario.getId()).get();

        if (!perguntaRespostaRepository.existsByFormularioAndPergunta(formulario, respostaFormulario.getPergunta())) {

            PerguntaResposta perguntaResposta = new PerguntaResposta();
            perguntaResposta.setPergunta(respostaFormulario.getPergunta());
            perguntaResposta.setResposta(respostaFormulario.getResposta());
            perguntaResposta.setFormulario(formulario);
            perguntaRespostaRepository.save(perguntaResposta);
        } else {
            atualizarResposta(respostaFormulario, formulario);
        }
        return formularioRepository.findById(formulario.getId()).get();
    }

    private void atualizarResposta(RespostaFormulario respostaFormulario, Formulario formulario) {
        var formularioAndPergunta = perguntaRespostaRepository.findByFormularioAndPergunta(formulario, respostaFormulario.getPergunta());
        formularioAndPergunta.setResposta(respostaFormulario.getResposta());
        entityManager.merge(formularioAndPergunta);
    }

}
