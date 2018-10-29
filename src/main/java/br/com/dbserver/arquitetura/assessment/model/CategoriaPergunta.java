package br.com.dbserver.arquitetura.assessment.model;

public enum CategoriaPergunta {

    CODE("Código"), BUILD("Build"), TEST("Teste de Artefatos"), RELEASE("Entrega"),
    DEPLOY("Instalação"), PLAN("Planejamento"), MONITOR("Monitoramento");


    public String getDescricao() {
        return descricao;
    }

    private String descricao;

    private CategoriaPergunta(final String descricao) {
        this.descricao = descricao;
    }
}
