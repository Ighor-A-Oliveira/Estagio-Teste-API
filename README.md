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

<div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(350px, 1fr)); gap: 18px; margin: 30px 0;">

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/user/register</code><br><br>
    Cadastro de novo usuário<br>
    <small>Campos: name, cpf, password</small>
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/user/login</code><br><br>
    Login com CPF e senha<br>
    Retorna access + refresh token
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/account/register</code><br><br>
    Cria conta bancária<br>
    <strong>Autenticação necessária</strong>
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/transaction/deposit</code><br><br>
    Realiza depósito na conta
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #fa709a 0%, #fee140 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/transaction/withdraw</code><br><br>
    Realiza saque da conta
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #a8edea 0%, #fed6e3 100%); color: #333; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(0,0,0,0.1);padding:4px 8px;border-radius:4px;">/transaction/internal-transfer</code><br><br>
    Transferência entre contas da mesma instituição
  </div>

  <div style="border-radius: 10px; padding: 18px; background: linear-gradient(135deg, #ff9a9e 0%, #fad0c4 100%); color: white; box-shadow: 0 4px 12px rgba(0,0,0,0.15);">
    <strong style="font-size: 1.1em;">POST</strong> <code style="background:rgba(255,255,255,0.2);padding:4px 8px;border-radius:4px;">/transaction/external-transfer</code><br><br>
    Transferência para outro banco (simulada)
  </div>

</div>

> Todos os endpoints de transação exigem token JWT no header: `Authorization: Bearer <token>`


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
