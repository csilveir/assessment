package br.com.dbserver.arquitetura.assessment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "pergunta", uniqueConstraints = {@UniqueConstraint(name = "pergunta_nome_uk", columnNames = {"nome"})})
public class Pergunta {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pergunta pergunta = (Pergunta) o;
        return Objects.equals(id, pergunta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;

    public CategoriaPergunta getCategoriaPergunta() {
        return categoriaPergunta;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaPergunta categoriaPergunta;
}
