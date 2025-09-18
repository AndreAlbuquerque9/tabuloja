# 🎲 Tabuloja - E-commerce de Jogos de Tabuleiro

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.X.X-green)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red)
![Architecture](https://img.shields.io/badge/Architecture-Hexagonal-purple)

Repositório do projeto de uma loja de aluguel e venda de jogos de tabuleiro, construído com foco em arquitetura limpa e boas práticas de desenvolvimento.

## 📝 Sobre o Projeto

Tabuloja é uma API RESTful para gerenciar um negócio de aluguel de jogos de tabuleiro. O projeto foi desenvolvido seguindo os princípios da **Arquitetura Hexagonal (Portas e Adaptadores)**, garantindo uma separação clara entre a lógica de negócio principal e as tecnologias de infraestrutura (web, banco de dados, etc.).

A estrutura de código está dividida nos seguintes módulos:
* **`core-domain`**: Contém as entidades e regras de negócio puras (ex: `Cliente`, `JogoDeTabuleiro`).
* **`application`**: Orquestra os casos de uso (`Services`) e define os contratos (`Ports`).
* **`adapters`**: Contém as implementações de tecnologia (web, persistência).
* **`bootstrap`**: O ponto de entrada da aplicação, responsável por inicializar o Spring Boot.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Persistência:** Spring Data JPA, Hibernate, H2 (Banco em memória para desenvolvimento)
* **Mapeamento:** MapStruct
* **Validação:** Spring Boot Starter Validation
* **Build:** Maven

## 🚀 Como Executar

### Pré-requisitos
* JDK 21 ou superior
* Apache Maven
* Uma IDE de sua preferência (ex: IntelliJ IDEA)

### Passos
1.  Clone o repositório:
    ```sh
    git clone [URL_DO_SEU_REPOSITORIO]
    ```
2.  Abra o projeto na sua IDE e aguarde o Maven baixar todas as dependências.
3.  Encontre o módulo **`bootstrap`** e execute a classe `TabulojaApplication.java`.
4.  A aplicação iniciará na porta `8080`.
5.  Você pode acessar o console do banco de dados H2 em `http://localhost:8080/h2-console`.
    * **JDBC URL:** `jdbc:h2:mem:tabulojadb`
    * **User Name:** `sa`
    * (Deixe a senha em branco)

## 📡 API Endpoints

A aplicação popula o banco com dados de teste na inicialização através da classe `DataInitializer`.

### Clientes

* **Cadastrar Cliente**
    * `POST /cliente`
    * **Body:**
        ```json
        {
            "nome": "Novo Cliente",
            "email": "novo@email.com",
            "clienteCpf": "99988877766"
        }
        ```
* **Buscar Cliente por CPF**
    * `GET /cliente?cpf=11122233344`

### Jogos de Tabuleiro

* **Cadastrar Jogo**
    * `POST /jogos`
    * **Body:**
        ```json
        {
            "titulo": "Ticket to Ride",
            "anoLancamento": 2004,
            "descricao": "Um jogo de aventura sobre viagens de trem.",
            "minJogadores": 2,
            "maxJogadores": 5,
            "tempoMedioMinutos": 60,
            "idadeMinima": 8,
            "autores": ["Alan R. Moon"],
            "publisher": "Days of Wonder",
            "categoria": "PRATA"
        }
        ```
* **Buscar Jogo por Título**
    * `GET /jogos?titulo=Catan`

### Pedidos de Aluguel

* **Criar Pedido de Aluguel**
    * `POST /alugueis`
    * **Body:**
        ```json
        {
            "clienteCpf": "11122233344",
            "jogosIds": ["COLE_O_UUID_DE_UM_JOGO_DO_SEU_BANCO_AQUI"],
            "diasAluguel": 5
        }
        ```
* **Buscar Pedido por ID**
    * `GET /alugueis/{id}`