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
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de desenvolvimento em TDD.', 'CODE', 'TDD é o desenvolvimento de software orientado a testes, ou em inglês, Test Driven Development. Mas mais do que simplesmente testar seu código, TDD é uma filosofia, uma cultura.')
insert into pergunta (nome, categoria, descricao) values ('Possui cultura de desenvolvimento por comportamento BDD.', 'CODE', 'Behavior Driven Development (BDD ou ainda uma tradução Desenvolvimento Guiado por Comportamento) é uma técnica de desenvolvimento Ágil que encoraja colaboração entre desenvolvedores, setores de qualidade e pessoas não-técnicas ou de negócios num projeto de software, se relaciona com o conceito de verificação e validação.')
insert into pergunta (nome, categoria, descricao) values ('As etapas de execução do pipeline é provisionada como código.', 'CODE', 'Tendo uma pipeline como código, a configuração do ambiente de CI é facilitada, não sendo preciso navegar por interfaces web, basta abrir o código e alterar algum passo. Além disso, podemos resgatar alguma configuração antiga com facilidade, já que sendo código, podemos colocá-lo sob controle de versão.')
insert into pergunta (nome, categoria, descricao) values ('Possui template de identação, formatação e estilo de código.', 'CODE', 'Um dos pontos principais de um código organizado é a indentação, o espaçamento que deixa claro o que é cada elemento no código permite que a sua visualização fique mais clara. Os recuos que separam classes e métodos fazem com que a escrita de centenas de linhas possa ser feita de forma muito precisa.')
insert into pergunta (nome, categoria, descricao) values ('O provisionamtuento dos ambientes computacionais é versionado como infraestrutura como código.', 'CODE', 'Infraestrutura como código (em inglês: infrastructure as code, ou IaC) é o processo de gerenciamento e provisionamento de centros de processamentos dados usando arquivos de configuração ao invés de configurações físicas de hardware ou ferramentas de configuração interativas')

insert into pergunta (nome, categoria, descricao) values ('Possui pipeline com automatização dos builds.', 'BUILD', 'O processo de implantação e liberação de versões de softwares em pipelines automatizados é aquele aonde a interferência humana passa somente por iniciar o processo como gatilho ou aprovar a implantação de forma assistida.')
insert into pergunta (nome, categoria, descricao) values ('Possui ferramenta de Quality Gate como Sonarqube, New Relic, PMD, Checkstyle ou outros.', 'BUILD', 'Um Quality Gate é uma verificação de um fato de qualidade de código que deve ser aplicado antes de liberar e, eventualmente, antes de se comprometer com o commit no source control.')
insert into pergunta (nome, categoria, descricao) values ('Possui métricas  bloqueantes de pipeline baseado em Quality Gate.', 'BUILD', 'Se a ferramenta de qualidade analisar o código submetido, e por qualquer motivo esse código violar as regras de qualidade, o pipeline irá abortar sua execução.')
insert into pergunta (nome, categoria, descricao) values ('Possui métricas de pipeline não baseadas em Quality Gate.', 'BUILD', 'Quando as métricas de qualidade são estipuladas pelo próprio time')
insert into pergunta (nome, categoria, descricao) values ('Guarda métricas de execução de pipelines.', 'BUILD', 'Quando os dados de execução de pipelines percentuais de cobertura, falhas ou sucessos de build são análisados pelo time em momento posterior.')

insert into pergunta (nome, categoria, descricao) values ('Efetua testes de unidades nos componentes.', 'TEST', 'Teste de unidade é toda a aplicação de teste nas assinaturas de entrada e saída de um sistema. Consiste em validar dados válidos e inválidos via I/O (entrada/saída) sendo aplicado por desenvolvedores ou analistas de teste.')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de integração entre componentes.', 'TEST', 'Teste de integração é a fase do teste de software em que módulos são combinados e testados em grupo. Ela sucede o teste de unidade.')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de contratos (no caso de aplicações de protocolo web).', 'TEST', 'Na fase inicial da concepção de um endpoint ou de um micro serviço, ocorre a modelagem e a documentação da API, lá está definido quais serão os tipos de respostas, como deverá ser o seu retorno e qual a tipagem dos campos de um contrato.')

insert into pergunta (nome, categoria, descricao) values ('Efetua testes e2e.', 'TEST','O teste de ponta a ponta é uma metodologia usada para testar se o fluxo de um aplicativo está funcionando conforme projetado do início ao fim. O objetivo da realização de testes de ponta a ponta é identificar as dependências do sistema e garantir que as informações corretas sejam transmitidas entre vários componentes e sistemas do sistema.')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de estresse.', 'TEST', 'Teste de stress é realizado para submeter o software a situações extremas. Basicamente, o teste de stress baseia-se em testar os limites do software e avaliar seu comportamento. Assim, avalia-se até quando o software pode ser exigido e quais as falhas (se existirem) decorrentes do teste.')
insert into pergunta (nome, categoria, descricao) values ('Efetua testes de aceitação.', 'TEST', 'Teste de aceitação é uma fase do processo de teste em que um teste de caixa-preta é realizado num sistema antes de sua disponibilização. Tem por função verificar o sistema em relação aos seus requisitos originais, e às necessidades atuais do usuário.')

insert into pergunta (nome, categoria, descricao) values ('Possui teste de penetração ou vulnerabilidade.', 'TEST', 'O teste de intrusão (do inglês "Penetration Test" ou pentest"), também traduzido como "teste de penetração", é um método que avalia a segurança de um sistema de computador ou de uma rede, simulando um ataque de uma fonte maliciosa.')

insert into pergunta (nome, categoria, descricao) values ('Cria tags para releases.', 'RELEASE', 'A tag costuma marcar um release, uma versão ou algo assim. Então a tag é apenas um apontador para um commit específico enquanto que um branch é um caminho, um galho de desenvolvimento, desta forma fica fácil acessar aquele estado sempre que for preciso.')

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



