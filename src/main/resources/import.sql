insert into resposta (nome) values ('Desconhece');
insert into resposta (nome) values ('Conhece');
insert into resposta (nome) values ('Pratica');
insert into resposta (nome) values ('Domina');
insert into resposta (nome) values ('Ensina');
insert into resposta (nome) values ('Não se Aplica');

insert into pergunta (nome, categoria, descricao) values ('Aplica técnicas de Clean Code.', 'CODE', 'Clean Code é uma filosofia de desenvolvimento cuja o principal objetivo é aplicar técnicas simples que visam facilitar a escrita e leitura de um código.')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de revisão de código por outros membros.', 'CODE', 'O próprio nome revisão de código deixa claro o objetivo da prática. A ideia é que o código escrito por um desenvolvedor, antes de ser promovido ao ambiente de produção, seja revisado por outro membro da equipe.')
insert into pergunta (nome, categoria, descricao) values ('Possui divisão do desenvolvimento das features em branchs separadas.', 'CODE', 'Features branches são usados para desenvolver novas funcionalidades para um realease futuro. Esses branches existem enquanto a funcionalidade está sendo desenvolvida, mas acabará quando essa for mesclada de volta ao branch develop.')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de refatoração em seu processo de trabalho.', 'CODE', 'A refatoração é uma técnica para alterar como o software faz alguma coisa, e não o que ele faz. Em efeitos práticos, você buscar melhorar o funcionamento do código sem deixar que o observador externo perceba a mudança.')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de merge request.', 'CODE', 'Merge request é um mecanismo onde um desenvolvedor pode gerar uma notificação que sinaliza a conclusão do desenvolvimento de uma feature qualquer. Isso permite que todos os envolvidos saibam que precisam fazer o merge do código na branch principal.')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de desenvolvimento em TDD.', 'CODE')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de desenvolvimento por comportamento BDD.', 'CODE')
insert into pergunta (nome, categoria, descricao) values ('As etapas de execução do pipeline é provisionada como código.', 'CODE')
insert into pergunta (nome, categoria, descricao) values ('Possui template de identação, formatação e estilo de código.', 'CODE')
insert into pergunta (nome, categoria, descricao) values ('O provisionamtuento dos ambientes computacionais é versionado como infraestrutura como código.', 'CODE')

insert into pergunta (nome, categoria, descricao) values ('Possui pipeline automatizado.', 'BUILD')
insert into pergunta (nome, categoria, descricao) values ('Possui ferramenta de Quality Gate como Sonarqube, New Relic, PMD, Checkstyle ou outros.', 'BUILD')
insert into pergunta (nome, categoria, descricao) values ('Possui métricas  bloqueantes de pipeline baseado em Quality Gate.', 'BUILD')
insert into pergunta (nome, categoria, descricao) values ('Possui métricas de pipeline não baseadas em Quality Gate.', 'BUILD')
insert into pergunta (nome, categoria, descricao) values ('Guarda métricas de execução de pipelines.', 'BUILD')

insert into pergunta (nome, categoria, descricao) values ('Efetua testes de unidades nos componentes.', 'TEST')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de integração entre componentes.', 'TEST')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de contratos (no caso de aplicações de protocolo web).', 'TEST')

insert into pergunta (nome, categoria, descricao) values ('Efetua testes e2e.', 'TEST')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de estresse.', 'TEST')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de aceitação.', 'TEST')

insert into pergunta (nome, categoria, descricao) values ('Possui teste de penetração ou vulnerabilidade.', 'TEST')

insert into pergunta (nome, categoria, descricao) values ('Cria tags para releases.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Pratica Continuous Integration.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Pratica Continuous Delivery.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Pratica Continuous Deployment.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Possui ferramenta de Continuous Database Migration.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Versiona os artefatos de software binários ou imagens docker em gerenciador de artefatos.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Cria CHANGELOG com as informações de cada release.', 'RELEASE')

insert into pergunta (nome, categoria, descricao) values ('Possui Blue-Green Deployment.', 'DEPLOY')

insert into pergunta (nome, categoria, descricao) values ('Possui Canary Release.', 'DEPLOY')

insert into pergunta (nome, categoria, descricao) values ('Possui A/B Testing.', 'DEPLOY')

insert into pergunta (nome, categoria, descricao) values ('Possui ambientes de teste e stage com semelhanças ao ambiente de produção.', 'DEPLOY')

insert into pergunta (nome, categoria, descricao) values ('Possui desenho, nem que mínimo, de seus componentes de software.', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('O time do projeto realiza sessões de design antes dos desenvolvimentos das features.', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('O time realiza discussões periódicas com a equipe de plataforma.', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('Possui canal ou ferramenta de comunicação do time.', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('Possui mural ou wiki do projeto contendo material de apoio para o time.', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('Possui definições e/ou planejamento de ASRs - Requisitos arquitetonicamente significativos', 'PLAN')

insert into pergunta (nome, categoria, descricao) values ('Possui a filosofia de SRE (Engenharia de confiabilidade do site)', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Possui ferramenta de monitoramento da aplicação sendo executada em produção.', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Possui testes de performance para melhoria de desempenho.', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Coleta dados de navegação ou experiência para melhoria de fluxos visuais.', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Possui ferramenta para visualização e/ou análise de logs.', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Persiste logs por determinada janela temporal para posterior análise ou correlação.', 'MONITOR')

insert into pergunta (nome, categoria, descricao) values ('Persiste métricas de softwares por determinada janela temporal para posterior análise ou correlação.', 'MONITOR')



