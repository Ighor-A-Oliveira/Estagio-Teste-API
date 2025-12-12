# Potencial-Teste-API

API REST desenvolvida em **Spring Boot 3 + Java 21** para o processo seletivo da Potencial.  
O projeto inclui autenticação JWT, refresh token, refresh token rotation, validações, testes unitários/integração e boas práticas de arquitetura.

[![Java 21](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Spring Boot 3](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16+-blue.svg)](https://www.postgresql.org/)

## Funcionalidades principais
- Cadastro e autenticação de usuários com JWT
- Refresh Token com rotação (refresh token rotation)
- Proteção de rotas com Spring Security
- Validações com Bean Validation
- Testes unitários e de integração (JUnit 5 + MockMvc)
- Documentação automática com SpringDoc OpenAPI (Swagger)

## Tecnologias utilizadas
- Java 21
- Spring Boot 3.3+
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Lombok
- SpringDoc OpenAPI

## Pré-requisitos

Antes de rodar o projeto, garanta que tenha instalado:

| Ferramenta         | Versão mínima | Como verificar                     |
|--------------------|---------------|------------------------------------|
| Java JDK           | 21            | `java -version`                    |
| Maven              | 3.8+          | `mvn -v`                           |
| PostgreSQL         | 15 ou superior| `psql --version`                   |

## Configuração do Banco de Dados

O projeto está configurado para usar o banco **PostgreSQL** local.

```sql
-- Conecte-se como superusuário (postgres) e execute:
CREATE DATABASE security_test;

CREATE USER spring_user WITH PASSWORD 'strongpassword';

GRANT ALL PRIVILEGES ON DATABASE security_test TO spring_user;


Como rodar o projeto localmente

# 1. Clone o repositório
git clone https://github.com/seu-usuario/potencial-teste-api.git
cd potencial-teste-api

# 2. (Opcional) Compile e baixe as dependências
mvn clean install

# 3. Inicie a aplicação
mvn spring-boot:run

A API ficará disponível em:
http://localhost:8080


### Endpoints da API

<div></div>

<div style="display:grid;grid-template-columns:repeat(auto-fit,minmax(320px,1fr));gap:16px;margin:30px 0">

<div style="border:1px solid #e1e4e8;border-left:5px solid #28a745;padding:16px;border-radius:6px;background:#f6fff8">
<strong>POST</strong> <code>/user/register</code><br>
Cadastro de novo usuário (nome, cpf, senha)
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #0366d6;padding:16px;border-radius:6px;background:#f6f8ff">
<strong>POST</strong> <code>/user/login</code><br>
Login com CPF → retorna JWT + refresh token
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #6f42c1;padding:16px;border-radius:6px;background:#faf8ff">
<strong>POST</strong> <code>/account/register</code><br>
Cria conta bancária para o usuário logado
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #d73a49;padding:16px;border-radius:6px;background:#fff8f8">
<strong>POST</strong> <code>/transaction/deposit</code><br>
Depósito em conta
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #d73a49;padding:16px;border-radius:6px;background:#fff8f8">
<strong>POST</strong> <code>/transaction/withdraw</code><br>
Saque da conta
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #f9a03f;padding:16px;border-radius:6px;background:#fffbf5">
<strong>POST</strong> <code>/transaction/internal-transfer</code><br>
Transferência entre contas da mesma instituição
</div>

<div style="border:1px solid #e1e4e8;border-left:5px solid #f9826c;padding:16px;border-radius:6px;background:#fff8f8">
<strong>POST</strong> <code>/transaction/external-transfer</code><br>
Transferência para outro banco (simulada)
</div>

</div>


Variáveis de ambiente
Caso queira alterar as credenciais do banco ou a porta da aplicação, crie um arquivo src/main/resources/application-local.properties ou use variáveis de ambiente:

server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/security_test
spring.datasource.username=spring_user
spring.datasource.password=strongpassword

jwt.secret=sua-chave-secreta-muito-forte-aqui
jwt.expiration=86400000          # 24h em ms
jwt.refresh-expiration=604800000 # 7 dias em ms


Estrutura do projeto

src/
 └── main/
      ├── java/com/example/potencial/
      │    ├── controller/
      │    ├── service/
      │    ├── repository/
      │    ├── security/
      │    ├── config/
      │    ├── dto/
      │    ├── exception/
      │    └── PotencialApplication.java
      └── resources/
           ├── application.properties
           └── application-local.properties (opcional)
