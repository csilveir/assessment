package br.com.dbserver.arquitetura.assessment.controller;


import br.com.dbserver.arquitetura.assessment.dto.RespostaFormulario;
import br.com.dbserver.arquitetura.assessment.model.Formulario;
import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import br.com.dbserver.arquitetura.assessment.model.PerguntaResposta;
import br.com.dbserver.arquitetura.assessment.model.Resposta;
import br.com.dbserver.arquitetura.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestoesController {

    public static final int UM = 1;
    public static final int ZERO = 0;
    @Autowired
    private AssessmentService assessmentService;

    @GetMapping(value = "/")
    public ModelAndView getQuestoes(@RequestParam(value = "pergunta", required = false) final Long pergunta, @RequestParam(value = "formulario", required = false) final Long formulario) {

        ModelAndView modelAndView = null;
        if (null == formulario && null == pergunta) {
            modelAndView = getModelAndView(null, null);
        } else {
            modelAndView = getModelAndViewPreenchido(pergunta, formulario);
        }

        return modelAndView;
    }

    private ModelAndView getModelAndViewPreenchido(@RequestParam(value = "pergunta", required = false) Long pergunta, @RequestParam(value = "formulario", required = false) Long formulario) {
        ModelAndView modelAndView;
        Optional<Formulario> formularioById = assessmentService.getFormularioRepository().findById(formulario);
        Optional<Pergunta> perguntaById = assessmentService.getPerguntaRepository().findById(pergunta);
        formularioById.orElseThrow(() -> new RuntimeException("Formulário Não Encontrado"));
        perguntaById.orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
        modelAndView = getModelAndView(perguntaById.get(),
                formularioById.get());
        return modelAndView;
    }


    private ModelAndView getModelAndView(final Pergunta pergunta, final Formulario savedForm) {
        ModelAndView modelAndView = new ModelAndView();
        List<Resposta> respostas = assessmentService.loadAllRespostas();

        RespostaFormulario formulario = getRespostaFormulario(pergunta, savedForm, respostas);
        formulario.setDtAvaliacao(new Date());
        modelAndView.addObject("formulario", formulario);
        modelAndView.addObject("respostas", respostas);
        modelAndView.setViewName("questoes");
        return modelAndView;
    }

    private RespostaFormulario getRespostaFormulario(Pergunta pergunta, Formulario savedForm, List<Resposta> respostas) {
        RespostaFormulario formulario = new RespostaFormulario();

        if (null == pergunta) {
            List<Pergunta> perguntas = assessmentService.loadAllPerguntas();
            formulario.setPergunta(perguntas.iterator().next());
        } else {
            formulario.setPergunta(pergunta);
        }
        if (null != savedForm) {
            formulario.setSprint(savedForm.getSprint());
            formulario.setTime(savedForm.getTime());
            formulario.setId(savedForm.getId());

            selectSaveResposta(pergunta, savedForm, respostas);

        }
        return formulario;
    }

    private void selectSaveResposta(Pergunta pergunta, Formulario formulario, List<Resposta> respostas) {
        PerguntaResposta persistedForm = assessmentService.getPerguntaRespostaRepository().findByFormularioAndPergunta(formulario, pergunta);
        respostas.forEach(resposta -> {

            if (resposta.equals(persistedForm)) {
                resposta.setChecked(true);
            }
        });
    }

    @PostMapping(value = "/salvarFormulario")
    public ModelAndView salvarFormulario(@ModelAttribute RespostaFormulario formulario) {
        Formulario saved = assessmentService.salvarResposta(formulario);
        List<Pergunta> perguntas = assessmentService.loadAllPerguntas();
        Optional<ModelAndView> nextQuestion = actionNext(saved, formulario.getPergunta());
        return nextQuestion.get();


    }

    private Optional<ModelAndView> actionNext(final Formulario formulario, final Pergunta pergunta) {

        List<Pergunta> perguntas = assessmentService.loadAllPerguntas();
        Optional<Pergunta> first = perguntas.parallelStream().filter(pergunta1 -> pergunta1.getId() > pergunta.getId()).findFirst();

        if (first.isPresent()) {

            return Optional.ofNullable(getModelAndView(first.get(), formulario));

        } else {
            return getModelAndView();
        }
    }

    private Optional<ModelAndView> getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("obrigado");
        return Optional.of(modelAndView);
    }
}