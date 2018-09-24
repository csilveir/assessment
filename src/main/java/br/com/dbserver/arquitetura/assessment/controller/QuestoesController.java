package br.com.dbserver.arquitetura.assessment.controller;


import br.com.dbserver.arquitetura.assessment.dto.RespostaFormulario;
import br.com.dbserver.arquitetura.assessment.model.Formulario;
import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import br.com.dbserver.arquitetura.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView getQuestoes() {

        ModelAndView modelAndView = getModelAndView(null, null);

        return modelAndView;
    }

    private ModelAndView getModelAndView(final Pergunta pergunta, final Formulario savedForm) {
        ModelAndView modelAndView = new ModelAndView();
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
        }
        formulario.setDtAvaliacao(new Date());
        modelAndView.addObject("formulario", formulario);
        modelAndView.addObject("respostas", assessmentService.loadAllRespostas());
        modelAndView.setViewName("questoes");
        return modelAndView;
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

        }
        return Optional.ofNullable(getQuestoes());
    }
}
