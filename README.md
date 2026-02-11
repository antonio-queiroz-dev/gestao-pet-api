# 🐾 Gestão Pet API

API REST desenvolvida com **Spring Boot 3**, **Java 21** e **MySQL** para o gerenciamento eficiente de pets e tutores.
O projeto adota práticas modernas de desenvolvimento, incluindo **Dockerização completa**, **Testes de Integração com Testcontainers**, **Cache com Redis** e documentação via **Swagger UI**.

---------------------------------------

## 🚀 Tecnologias Utilizadas

* **Java 21** (LTS)
* **Spring Boot 3.5.6**
    * Spring Web
    * Spring Data JPA
    * Spring Data Redis
* **Banco de Dados**: MySQL 8
* **Cache**: Redis
* **Containerização**: Docker & Docker Compose
* **Testes**:
    * JUnit 5 + Mockito (Unitários)
    * **Testcontainers** (Integração) 
    * **Documentação**: SpringDoc OpenAPI (Swagger UI)
* **Build**: Maven

---

## ⚙️ Pré-requisitos

* **Docker Desktop** (Obrigatório)
* **Git**

---

## ▶️ Como Executar (Via Docker)

A maneira mais simples de rodar a aplicação é utilizando o Docker Compose. Isso subirá o banco de dados, o cache Redis e a API automaticamente.

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Antonio-scripts/gestao-pet-api.git
   cd gestao-pet-api
   ```

2. **Suba a aplicação:**
   ```bash
   docker compose up --build
   ```
   *Aguarde alguns instantes até que todos os containers estejam saudáveis (healthy).*

3. **Acesse a API:**
   A aplicação estará rodando em: `http://localhost:8080`

---

## 💻 Desenvolvimento Local (Opcional)

Caso queira rodar a aplicação via IDE (IntelliJ/Eclipse) para desenvolvimento:

1. Suba apenas a infraestrutura (MySQL + Redis):
   ```bash
   docker compose up -d mysql redis
   ```
2. Configure sua IDE para usar o perfil `dev` (`-Dspring.profiles.active=dev`).
3. Execute a classe `GestaoPetApiApplication`.

---

## 📚 Documentação da API (Swagger)

Com a aplicação rodando, acesse a documentação interativa para testar os endpoints:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## 🧠 Funcionalidades Principais

### 🐶 Pets
* **CRUD Completo**: Cadastro, listagem, atualização e remoção.
* **Buscas Avançadas**: Por nome, sexo, idade e tutor.
* **Validações de Negócio**:
    * Idade máxima de 20 anos.
    * Peso entre 0.5kg e 60kg.
    * Validação de nome (nome e sobrenome)

### 👤 Tutores
* **CRUD Completo**.
* **Validação Estrutural**: Uso de Bean Validation (`@NotBlank`, `@Email`).

---

## ⚡ Performance e Cache

O projeto utiliza **Redis** para cachear consultas frequentes (`@Cacheable`), reduzindo a carga no banco de dados. O cache é invalidado automaticamente (`@CacheEvict`) quando dados são alterados, garantindo consistência.

---

## 🧪 Testes Automatizados

O projeto possui testes automatizados:

1.  **Testes Unitários**: Validam a lógica de negócio isolada (Services) usando Mockito.
2.  **Testes de Integração**: Usam **Testcontainers** para subir um banco MySQL real e descartável durante os testes, garantindo que a aplicação funcione de ponta a ponta.

Para rodar os testes (requer Java/Maven instalados):
```bash
mvn test
```

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura limpa em camadas:
* **Controller**:
* **Service**:
* **Repository**:
* **DTOs (Records)**:
* **Model**

---

## 🚧 Roadmap (Evolução)

- [x] Criar testes de integração
- [x] Dockerizar completamente a aplicação
- [x] Implementar Cache com Redis
- [ ] Implementar CI/CD com GitHub Actions
- [ ] Publicar na AWS (EC2 ou ECS)

---

## 🧑‍💻 Autor

Desenvolvido por **Antonio Queiroz**

💼 [LinkedIn](https://www.linkedin.com/in/antonio-queiroz-2983491a2/) | 🐙 [GitHub](https://github.com/Antonio-scripts)
