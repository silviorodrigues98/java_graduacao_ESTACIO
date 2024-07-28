# Projeto de Sistema de Agendamentos para Academia Comunitária

## Sumário
- [Projeto de Sistema de Agendamentos para Academia Comunitária](#projeto-de-sistema-de-agendamentos-para-academia-comunitária)
  - [Sumário](#sumário)
  - [Introdução](#introdução)
  - [Requisitos](#requisitos)
  - [Instalação](#instalação)
  - [Uso](#uso)
    - [Login](#login)
    - [Cadastrar Horário](#cadastrar-horário)
    - [Ver Meus Horários](#ver-meus-horários)
  - [Estrutura do Código](#estrutura-do-código)
  - [Contribuição](#contribuição)
  - [Licença](#licença)

## Introdução
Este projeto consiste em um sistema de agendamentos para uma academia comunitária. O sistema permite que os usuários se cadastrem e façam login, selecionem datas e horários para agendamento, e visualizem seus agendamentos.

## Requisitos
- Java JDK 8 ou superior
- Um ambiente de desenvolvimento Java, como Eclipse ou IntelliJ IDEA

## Instalação
1. **Clone o repositório:**
   ```sh
   git clone https://github.com/silviorodrigues98/java_graduacao_ESTACIO
   ```

2. **Compile o projeto:**
   Abra o projeto no seu ambiente de desenvolvimento Java e compile o código.

3. **Execute o projeto:**
   Execute a classe `App` para iniciar a aplicação.

## Uso

### Login
1. **Abrir a aplicação:**
   Ao iniciar a aplicação, uma tela de login será exibida.

2. **Inserir as credenciais:**
   - **Usuário:** `admin`
   - **Senha:** `admin`

3. **Clicar no botão "Login":**
   - Se as credenciais estiverem corretas, você será redirecionado para a tela principal.
   - Se as credenciais estiverem incorretas, uma mensagem de erro será exibida.

### Cadastrar Horário
1. **Clique no botão "CADASTRAR HORÁRIO".**
2. **Selecione a data desejada usando o seletor de datas.**
3. **Clique em "Confirmar".**
4. **Selecione um ou mais horários disponíveis clicando nos botões de horário.**
   - Os botões clicados ficarão verdes e desabilitados para indicar a seleção.
5. **Clique no botão "SALVAR".**
   - Seus agendamentos serão salvos em um arquivo `agendamentos.txt`.

### Ver Meus Horários
1. **Clique no botão "VER MEUS HORÁRIOS".**
2. **Uma tela com todos os seus agendamentos salvos será exibida.**

## Estrutura do Código
- **Classe `App`:**
  - Contém o método `main` que inicializa a aplicação.
  - Implementa a interface gráfica e a lógica de login.
  - Gerencia o fluxo entre as telas de cadastro de horários e visualização de agendamentos.

- **Componentes principais:**
  - **Tela de Login:** Interface para entrada de credenciais.
  - **Tela Principal:** Menu com opções para cadastrar novos horários ou visualizar agendamentos.
  - **Tela de Cadastro de Horários:** Permite ao usuário selecionar datas e horários para agendamento.
  - **Tela de Visualização de Agendamentos:** Exibe os agendamentos salvos do usuário.

## Contribuição
1. **Fork o repositório**
2. **Crie uma branch com a nova feature (`git checkout -b feature/nova-feature`)**
3. **Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)**
4. **Push para a branch (`git push origin feature/nova-feature`)**
5. **Crie um novo Pull Request**

## Licença
Este projeto está licenciado sob a Licença MIT