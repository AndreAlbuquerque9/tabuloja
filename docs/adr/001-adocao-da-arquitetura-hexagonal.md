# ADR 001: Adoção da Arquitetatura Hexagonal

**Status:** Aceito

## Contexto

Precisávamos definir uma arquitetura para a aplicação Tabuloja que garantisse uma clara separação entre a lógica de negócio principal e as dependências externas (como o framework web, banco de dados, gateways de pagamento, etc.). Os objetivos principais eram:
* Maximizar a testabilidade do núcleo de negócio de forma isolada.
* Permitir que a tecnologia (ex: banco de dados) possa ser trocada no futuro com o mínimo de impacto no código de negócio.
* Manter uma estrutura organizada e com baixo acoplamento, facilitando a manutenção e a evolução do projeto.

## Decisão

Nós decidimos adotar a **Arquitetura Hexagonal (Portas e Adaptadores)**.

A estrutura do nosso projeto foi dividida em módulos que refletem essa decisão:
* **`core-domain`**: Contém as entidades e regras de negócio puras, sem nenhuma dependência externa.
* **`application`**: Contém os casos de uso (Services) e os contratos (`Ports`/interfaces) que definem as fronteiras do nosso negócio.
* **`adapters`**: Contém as implementações concretas das `Ports`, conectando o núcleo do negócio com o mundo exterior (ex: `persistence-adapter` com Spring Data JPA, `web-adapter` com Spring MVC).

A regra principal de dependência é que as setas sempre apontam para o centro: os `adapters` dependem da `application`, mas a `application` e o `core-domain` não dependem dos `adapters`.

## Consequências

### Positivas
* **Alta Testabilidade:** O `core-domain` e a `application` podem ser testados com testes unitários puros, sem a necessidade de subir um banco de dados ou um servidor web.
* **Flexibilidade Tecnológica:** A implementação de um `Port` pode ser trocada. Por exemplo, podemos criar um `mongodb-persistence-adapter` e trocá-lo pelo `jpa-persistence-adapter` com pouquíssimas mudanças no resto da aplicação.
* **Separação de Responsabilidades:** O código fica muito bem organizado. É fácil saber onde encontrar a lógica de negócio versus o código de infraestrutura.

### Negativas
* **Aumento de Boilerplate:** O número de classes e interfaces é maior em comparação com uma arquitetura em camadas mais simples (ex: `Cliente`, `ClienteRepositoryPort`, `ClientePersistenceAdapter`, `ClienteJpaEntity`, `ClienteMapper`).
* **Curva de Aprendizagem:** A equipe precisa entender o conceito de Portas e Adaptadores e a regra de inversão de dependência para trabalhar efetivamente no projeto.