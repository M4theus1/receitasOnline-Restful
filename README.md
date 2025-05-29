
# 📌 ReceitasOnline - API Restful

Uma API desenvolvida em **Java/Spring Boot** para gerenciar receitas culinárias, ingredientes e categorias. Projeto focado em boas práticas de desenvolvimento back-end, como clean code, arquitetura em camadas e padrões RESTful.

---

## 🛠️ Tecnologias

- **Java 17**  
- **Spring Boot 3.x**  
- **Spring Data JPA** (Hibernate)  
- **Lombok**  
- **Maven**  
- **Banco de dados**: H2 (dev) / PostgreSQL (prod)  
- **Documentação**: Swagger/OpenAPI (em implementação)  

---

## 📂 Estrutura do Projeto


src/main/java/com/example/demo/
├── config/       → Configurações globais (CORS, segurança, etc.)
├── controller/   → Endpoints REST
├── dto/          → Data Transfer Objects (DTOs)
├── exception/    → Tratamento personalizado de erros
├── model/        → Entidades JPA (Receita, Ingrediente, Categoria)
├── repository/   → Interfaces Spring Data JPA
├── service/      → Lógica de negócio e regras
└── DemoApplication.java → Ponto de inicialização


---

## 🔍 Endpoints Principais

| Método | Rota                     | Descrição                          |
|--------|--------------------------|------------------------------------|
| GET    | /receitas             | Lista todas as receitas            |
| POST   | /receitas              | Cria uma nova receita              |
| GET    | /receitas/{id}         | Busca receita por ID               |
| PUT    | /receitas/{id}         | Atualiza uma receita               |
| DELETE | /receitas/{id}        | Remove uma receita                 |
| GET    | /receitas/categoria/{nome} | Filtra receitas por categoria  |

(Lista completa disponível no Swagger UI após execução)

---

## 🚀 Como Executar

1. Pré-requisitos:  
   - JDK 17+  
   - Maven 3.8+  
   - Banco de dados configurado (arquivo `application.properties`).  

2. Clone o repositório:  
   bash
   git clone https://github.com/seu-usuario/receitasOnline-Restful.git
   

3. Instale as dependências e execute:  
   bash
   mvn spring-boot:run


4. Acesse a API:  
   - Local: `http://localhost:8080`  
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

---

```
