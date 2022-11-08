## Avaliação Teórica ##

Edite o arquivo chamado Respostas.txt e responda as seguintes questões:

1 – Explique, detalhadamente, como recuperar um conjunto de linhas de uma tabela de um banco de dados relacional e transformar em um conjunto de objetos em Java.
2 – O que é uma interface em Java?
3 – Explique o que é um DAO?
4 – Foi solicitado a você escrever um programa em Java que realize um CRUD de clientes. O que isso significa?
5 – Durante o processo de revisão de um código-fonte você encontrou uma operação de inserção em um banco de dados escrita diretamente no método de ação de um botão. Isso está correto? Se não está, como é possível melhorar o código-fonte?

Ao terminar de responder as perguntas faça um commit!

## Avaliação Prática ##

Este sistema permite o cadastro de livros em um banco de dados SQLite.  Também é possível listar os livras previamente cadastrados, utilizando um TableView. O arquivo do banco, bem como o script de criação, são fornecidos.

Regras de implementação:

1. Modifique o código-fonte para que o sistema funcione efetivamente.
2. O código criado DEVE utilizar a divisão em camadas mostrada durante as aulas.
3. O código criado DEVE utilizar injeção de dependências.
4. DEVE ser utilizado o padrão DAO. 
5. DEVE ser criada uma interface que define os métodos a serem implementados no DAO.
6. A implementação do DAO DEVE possuir uma dependência para a FabricaConexoes.
7. DEVE ser utilizado o padrão repository.
8. O repositório deve verificar se o número de páginas é maior que zero e o ano de publicação é menor que o ano atual. Em caso negativo para qualquer uma das restrições, uma mensagem de falha deve ser gerada. Para obter o ano atual: int year = LocalDate.now().getYear();
9. O repository DEVE comunicar com o DAO de livros.
10. O TelaLivrosViewModel DEVE comunicar com o repositório de livros.
11. DEVEM existir ao menos 5 commits referentes a implementação
