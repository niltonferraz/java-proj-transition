# 📊 API de Gestão de Orçamentos (`api-gestao-orcamentos`)

> API RESTful desenvolvida em Java com Spring Boot para gerenciamento completo do ciclo de vida de orçamentos comerciais.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3.x
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database (Banco em memória para ambiente de desenvolvimento)
* **Validação de Dados:** Jakarta Bean Validation (Hibernate Validator)
* **Gerenciador de Dependências:** Apache Maven

---

## 🏛️ Arquitetura e Boas Práticas

A aplicação segue o padrão de **Arquitetura em Camadas (Layered Architecture)**, priorizando o desacoplamento, a testabilidade e o cumprimento dos princípios SOLID:

* **`Controller`:** Responsável por expor as rotas HTTP, manipular requisições/respostas e aplicar códigos de status HTTP apropriados (`200 OK`, `201 Created`, `204 No Content`, `400 Bad Request`, `404 Not Found`).
* **`Service`:** Concentra toda a lógica de negócios e orquestra as regras de validação e transformação dos dados.
* **`Repository`:** Camada de abstração do Spring Data JPA para acesso e manipulação de dados no H2.
* **`DTO (Data Transfer Object)`:** Garante o desacoplamento entre os modelos de banco de dados (`Entities`) e os contratos expostos na API (`Request` e `Response`), reforçando a segurança dos dados.
* **`Global Exception Handler`:** Manipulador global de exceções anotado com `@RestControllerAdvice` que captura falhas de validação de campo (`MethodArgumentNotValidException`) e erros de recurso não encontrado, devolvendo respostas padronizadas e amigáveis ao cliente.

---

## 🚀 Endpoints da API

A rota base para as operações é `/api/orcamentos`.

| Método | Endpoint | Descrição | Status HTTP |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/orcamentos` | Lista todos os orçamentos cadastrados | `200 OK` |
| `GET` | `/api/orcamentos/{id}` | Busca um orçamento pelo ID | `200 OK` / `404 Not Found` |
| `POST` | `/api/orcamentos` | Cria um novo orçamento | `201 Created` / `400 Bad Request` |
| `PUT` | `/api/orcamentos/{id}` | Atualiza os dados de um orçamento existente | `200 OK` / `400 Bad Request` / `404 Not Found` |
| `DELETE` | `/api/orcamentos/{id}` | Remove um orçamento pelo ID | `204 No Content` / `404 Not Found` |

---

## 📝 Exemplo de Payload (Criar/Atualizar Orçamento)

### Requisição (`POST` / `PUT`)

```json
{
  "cliente": "Empresa Alfa",
  "descricao": "Desenvolvimento de API REST e Automação de Testes",
  "valorTotal": 4500.00,
  "status": "PENDENTE"
}
```
---

### Resposta de Erro de Validação (`400 Bad Request`)

Se campos obrigatórios ou regras de validação forem violadas:

```json
{
  "cliente": "O nome do cliente é obrigatório.",
  "valorTotal": "O valor total deve ser maior que zero."
}
```
---

## ⚙️ Como Executar o Projeto Localmente
### Pré-requisitos
* Java JDK 17 ou superior instalado

* Apache Maven instalado (ou utilizar o wrapper ./mvnw)

* Git para clonagem do repositório


### Passo a Passo
1. Clonar o repositório:

    
    git clone [https://github.com/niltonferraz/java-proj-transition.git](https://github.com/niltonferraz/java-proj-transition.git)

2. Acessar a pasta do projeto:

    
    cd java-proj-transition

3. Compilar e baixar as dependências:

    
    mvn clean install

4. Executar a aplicação:

    
    mvn spring-boot:run

5. Acessar a API:

    A API estará rodando em http://localhost:8081 (ou na porta configurada no seu application.properties).

## 📂 Acesso ao Banco de Dados H2 Console
Enquanto a aplicação estiver em execução, o console interativo do H2 estará disponível em:

URL: http://localhost:8081/h2-console

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (deixe em branco)