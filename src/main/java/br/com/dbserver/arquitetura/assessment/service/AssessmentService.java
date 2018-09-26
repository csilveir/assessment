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
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        List<Pergunta> all = perguntaRepository.findAll();
        all.sort(Comparator.comparing(Pergunta::getId));

        return all;
    }

    public List<Resposta> loadAllRespostas() {

        List<Resposta> all = respostaRepository.findAll();
        all.sort(Comparator.comparing(Resposta::getId));
        return all;
    }

    public Formulario salvarResposta(final RespostaFormulario respostaFormulario) {

        Formulario save = null;


        if (null == respostaFormulario.getId()) {

            if (formularioRepository.existsByTimeAndSprint(respostaFormulario.getTime(), respostaFormulario.getSprint())) {

                throw new RuntimeException(String.format("Avaliação do time %s na sprint %d já foi efetuada!", respostaFormulario.getTime(), respostaFormulario.getSprint()));
            }

            save = new Formulario();
            respostaFormulario.setDtAvaliacao(new Date());
            save.setTime(respostaFormulario.getTime());
            save.setDtAvaliacao(respostaFormulario.getDtAvaliacao());
            save.setSprint(respostaFormulario.getSprint());
            save = formularioRepository.save(save);


        } else {
            Optional<Formulario> formularioById = formularioRepository.findById(respostaFormulario.getId());
            formularioById.orElseThrow(() -> new RuntimeException("Inválido formulário"));
            save = formularioById.get();
        }


        return inserirResposta(respostaFormulario, save);


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
        PerguntaResposta byFormularioAndPergunta = perguntaRespostaRepository.findByFormularioAndPergunta(formulario, respostaFormulario.getPergunta());
        byFormularioAndPergunta.setResposta(respostaFormulario.getResposta());
        entityManager.merge(byFormularioAndPergunta);
    }

}
