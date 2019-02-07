package br.com.dbserver.arquitetura.assessment.controller;


import br.com.dbserver.arquitetura.assessment.dto.RespostaFormulario;
import br.com.dbserver.arquitetura.assessment.model.*;
import br.com.dbserver.arquitetura.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

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
        final var formularioById = assessmentService.getFormularioRepository().findById(formulario);
        final var perguntaById = assessmentService.getPerguntaRepository().findById(pergunta);
        formularioById.orElseThrow(() -> new RuntimeException("Formulário não Encontrado!"));
        perguntaById.orElseThrow(() -> new RuntimeException("Pergunta não encontrada!"));
        modelAndView = getModelAndView(perguntaById.get(),
                formularioById.get());
        modelAndView.addObject("categorias",
                Arrays.asList(CategoriaPergunta.values()).stream().map(CategoriaPergunta::getDescricao).distinct().collect(Collectors.toList()));
        return modelAndView;
    }


    private ModelAndView getModelAndView(final Pergunta pergunta, final Formulario savedForm) {
        final var modelAndView = new ModelAndView();
        final var respostas = assessmentService.loadAllRespostas();

        final RespostaFormulario formulario = getRespostaFormulario(pergunta, savedForm, respostas, modelAndView);
        formulario.setDtAvaliacao(new Date());
        modelAndView.addObject("formulario", formulario);
        modelAndView.addObject("respostas", respostas);
        modelAndView.setViewName("questoes");
        modelAndView.addObject("categorias",
                Arrays.asList(CategoriaPergunta.values()).stream().map(CategoriaPergunta::getDescricao).distinct().collect(Collectors.toList()));
        return modelAndView;
    }

    private RespostaFormulario getRespostaFormulario(Pergunta pergunta, Formulario formulario, List<Resposta> respostas, final ModelAndView modelAndView) {
        final RespostaFormulario respostaFormulario = new RespostaFormulario();

        if (null == pergunta) {
            List<Pergunta> perguntas = assessmentService.loadAllPerguntas();


            respostaFormulario.setPergunta(perguntas.iterator().next());
        } else {
            respostaFormulario.setPergunta(pergunta);
        }
        if (null != formulario) {
            respostaFormulario.setSprint(formulario.getSprint());
            respostaFormulario.setTime(formulario.getTime());
            respostaFormulario.setId(formulario.getId());

            selectSaveResposta(pergunta, formulario, respostas, modelAndView);

        }
        return respostaFormulario;
    }

    private void selectSaveResposta(Pergunta pergunta, Formulario formulario, List<Resposta> respostas, final ModelAndView modelAndView) {
        final PerguntaResposta perguntaResposta = assessmentService.getPerguntaRespostaRepository().findByFormularioAndPergunta(formulario, pergunta);
        if (Objects.nonNull(perguntaResposta))
            respostas.forEach(resposta -> {

                if (resposta.equals(perguntaResposta.getResposta())) {
                    resposta.setChecked(true);
                    modelAndView.addObject("checked", "resposta" + resposta.getId());
                }
            });
    }

    @PostMapping(value = "/formulario")
    public ModelAndView salvarFormulario(@ModelAttribute RespostaFormulario formulario) {
        Formulario saved = assessmentService.salvarFormulario(formulario);
        List<Pergunta> perguntas = assessmentService.loadAllPerguntas();
        Optional<ModelAndView> nextQuestion = actionNext(saved, formulario.getPergunta());
        return nextQuestion.get();


    }

    private Optional<ModelAndView> actionNext(final Formulario formulario, final Pergunta pergunta) {

        final List<Pergunta> perguntas = assessmentService.loadAllPerguntas();
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

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handle(RuntimeException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getLocalizedMessage());
        modelAndView.setViewName("erro");
        return modelAndView;
    }
}
