insert into resposta (nome) values ('Desconhece');
insert into resposta (nome) values ('Conhece');
insert into resposta (nome) values ('Pratica');
insert into resposta (nome) values ('Domina');
insert into resposta (nome) values ('Ensina');
insert into resposta (nome) values ('Não se Aplica');

insert into pergunta (nome, categoria) values ('Aplica técnicas de Clean Code.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui cultura de revisão de código por outros membros.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui divisão do desenvolvimento das features em       branchs separadas.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui cultura de refatoração em seu processo de trabalho.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui cultura de merge request.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui cultura de desenvolvimento em TDD.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui cultura de desenvolvimento por comportamento BDD.', 'CODE')
insert into pergunta (nome, categoria) values ('As etapas de execução do pipeline é provisionada como código.', 'CODE')
insert into pergunta (nome, categoria) values ('Possui template de identação, formatação e estilo de código.', 'CODE')
insert into pergunta (nome, categoria) values ('O provisionamtuento dos ambientes computacionais é versionado como infraestrutura como código.', 'CODE')

insert into pergunta (nome, categoria) values ('Possui pipeline automatizado.', 'BUILD')
insert into pergunta (nome, categoria) values ('Possui ferramenta de Quality Gate como Sonarqube, New Relic, PMD, Checkstyle ou outros.', 'BUILD')
insert into pergunta (nome, categoria) values ('Possui métricas  bloqueantes de pipeline baseado em Quality Gate.', 'BUILD')
insert into pergunta (nome, categoria) values ('Possui métricas de pipeline não baseadas em Quality Gate.', 'BUILD')
insert into pergunta (nome, categoria) values ('Guarda métricas de execução de pipelines.', 'BUILD')

insert into pergunta (nome, categoria) values ('Efetua testes de unidades nos componentes.', 'TEST')
insert into pergunta (nome, categoria) values ('Efetua testes de integração entre componentes.', 'TEST')
insert into pergunta (nome, categoria) values ('Efetua testes de contratos (no caso de aplicações de protocolo web).', 'TEST')

insert into pergunta (nome, categoria) values ('Efetua testes e2e.', 'TEST')
insert into pergunta (nome, categoria) values ('Efetua testes de estresse.', 'TEST')
insert into pergunta (nome, categoria) values ('Efetua testes de aceitação.', 'TEST')

insert into pergunta (nome, categoria) values ('Possui teste de penetração ou vulnerabilidade.', 'TEST')

insert into pergunta (nome, categoria) values ('Cria tags para releases.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Pratica Continuous Integration.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Pratica Continuous Delivery.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Pratica Continuous Deployment.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Possui ferramenta de Continuous Database Migration.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Versiona os artefatos de software binários ou imagens docker em gerenciador de artefatos.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Cria CHANGELOG com as informações de cada release.', 'RELEASE')

insert into pergunta (nome, categoria) values ('Possui Blue-Green Deployment.', 'DEPLOY')

insert into pergunta (nome, categoria) values ('Possui Canary Release.', 'DEPLOY')

insert into pergunta (nome, categoria) values ('Possui A/B Testing.', 'DEPLOY')

insert into pergunta (nome, categoria) values ('Possui ambientes de teste e stage com semelhanças ao ambiente de produção.', 'DEPLOY')

insert into pergunta (nome, categoria) values ('Possui desenho, nem que mínimo, de seus componentes de software.', 'PLAN')

insert into pergunta (nome, categoria) values ('O time do projeto realiza sessões de design antes dos desenvolvimentos das features.', 'PLAN')

insert into pergunta (nome, categoria) values ('O time realiza discussões periódicas com a equipe de plataforma.', 'PLAN')

insert into pergunta (nome, categoria) values ('Possui canal ou ferramenta de comunicação do time.', 'PLAN')

insert into pergunta (nome, categoria) values ('Possui mural ou wiki do projeto contendo material de apoio para o time.', 'PLAN')

insert into pergunta (nome, categoria) values ('Possui definições e/ou planejamento de ASRs - Requisitos arquitetonicamente significativos', 'PLAN')

insert into pergunta (nome, categoria) values ('Possui a filosofia de SRE (Engenharia de confiabilidade do site)', 'MONITOR')

insert into pergunta (nome, categoria) values ('Possui ferramenta de monitoramento da aplicação sendo executada em produção.', 'MONITOR')

insert into pergunta (nome, categoria) values ('Possui testes de performance para melhoria de desempenho.', 'MONITOR')

insert into pergunta (nome, categoria) values ('Coleta dados de navegação ou experiência para melhoria de fluxos visuais.', 'MONITOR')

insert into pergunta (nome, categoria) values ('Possui ferramenta para visualização e/ou análise de logs.', 'MONITOR')

insert into pergunta (nome, categoria) values ('Persiste logs por determinada janela temporal para posterior análise ou correlação.', 'MONITOR')

insert into pergunta (nome, categoria) values ('Persiste métricas de softwares por determinada janela temporal para posterior análise ou correlação.', 'MONITOR')

