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

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AssessmentService {


    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private PerguntaRespostaRepository perguntaRespostaRepository;


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
            save = new Formulario();
            respostaFormulario.setDtAvaliacao(new Date());
            save.setTime(respostaFormulario.getTime());
            save.setDtAvaliacao(respostaFormulario.getDtAvaliacao());
            save.setSprint(respostaFormulario.getSprint());
            save = formularioRepository.save(save);


        } else {
            save = formularioRepository.findById(respostaFormulario.getId()).get();
        }


        return inserirResposta(respostaFormulario, save);


    }

    private Formulario inserirResposta(RespostaFormulario respostaFormulario, Formulario formulario) {


        formulario = formularioRepository.findById(formulario.getId()).get();

        if (!perguntaRespostaRepository.existsByFormularioAndPergunta (formulario, respostaFormulario.getPergunta())) {

            PerguntaResposta perguntaResposta = new PerguntaResposta();
            perguntaResposta.setPergunta(respostaFormulario.getPergunta());
            perguntaResposta.setResposta(respostaFormulario.getResposta());
            perguntaResposta.setFormulario(formulario);
            perguntaRespostaRepository.save(perguntaResposta);
        }
        return formularioRepository.findById(formulario.getId()).get();
    }

}
