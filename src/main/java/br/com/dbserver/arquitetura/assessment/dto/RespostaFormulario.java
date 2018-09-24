package br.com.dbserver.arquitetura.assessment.dto;

import br.com.dbserver.arquitetura.assessment.model.Pergunta;
import br.com.dbserver.arquitetura.assessment.model.Resposta;

import java.util.Date;

public class RespostaFormulario {

    private Date dtAvaliacao;
    private Integer sprint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    private Pergunta pergunta;

    public Pergunta getPergunta() {
        return pergunta;
    }

    public Date getDtAvaliacao() {
        return dtAvaliacao;
    }

    public void setDtAvaliacao(Date dtAvaliacao) {
        this.dtAvaliacao = dtAvaliacao;
    }

    public Integer getSprint() {
        return sprint;
    }

    public void setSprint(Integer sprint) {
        this.sprint = sprint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    private String time;


    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    private Resposta resposta;

}
