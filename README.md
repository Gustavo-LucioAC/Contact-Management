# Contact-Management

Gerenciador de Contatos
Este projeto é uma aplicação em Java para gerenciamento de contatos pessoais. Desenvolvida com Java Swing, a aplicação oferece uma interface gráfica simples e intuitiva para adicionar, remover, listar e buscar contatos. É ideal para aqueles que desejam organizar informações de contato com validações básicas e evitar duplicações de telefone.

Funcionalidades
Adicionar Contato: Adicione um novo contato informando nome, email e telefone. Validações garantem que o email esteja no formato correto e que o telefone não seja duplicado.
Remover Contato: Remova contatos da lista pelo nome.
Buscar por Telefone: Encontre rapidamente um contato buscando pelo número de telefone.
Listar Contatos: Exiba todos os contatos cadastrados em ordem de inserção, com detalhes de nome, email e telefone.
Estrutura do Projeto
Contato: Classe que representa cada contato individual, armazenando nome, email e uma lista de telefones.
GerenciadorContatos: Classe responsável pela lógica de armazenamento, validações e busca de contatos, usando estruturas de dados como ArrayList, HashSet e TreeMap para garantir a integridade dos dados e facilitar o acesso.
ContatoApp: Interface gráfica em Swing que permite interagir com as funcionalidades do Gerenciador de Contatos.
Tecnologias e Estruturas de Dados
Java Swing: Para a criação da interface gráfica.
ArrayList: Armazena os contatos em ordem de inserção.
HashSet: Garante a unicidade dos números de telefone.
TreeMap: Armazena os contatos ordenados por nome, permitindo buscas eficientes.
Como Executar
Clone o repositório:
bash
Copiar código
git clone https://github.com/seuusuario/gerenciador-contatos.git
Compile o projeto:
bash
Copiar código
javac ContatoApp.java
Execute o aplicativo:
bash
Copiar código
java ContatoApp
Exemplo de Uso
Preencha os campos de Nome, Email e Telefone.
Clique em Adicionar Contato para adicionar o contato à lista.
Use os botões Remover Contato, Buscar por Telefone e Listar Contatos para gerenciar os contatos conforme necessário.
