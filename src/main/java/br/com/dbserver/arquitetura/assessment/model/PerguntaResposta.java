package br.com.dbserver.arquitetura.assessment.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "pergunta_resposta", uniqueConstraints = {@UniqueConstraint(name = "pergunta_resposta_uk", columnNames = {"id_formulario", "id_pergunta"})})
public class PerguntaResposta {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    @ManyToOne
    @JoinColumn(name = "id_formulario", referencedColumnName = "id")
    private Formulario formulario;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerguntaResposta that = (PerguntaResposta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }



    @ManyToOne
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id")
    private Pergunta pergunta;

    @ManyToOne
    @JoinColumn(name = "id_resposta", referencedColumnName = "id")
    private Resposta resposta;

}
