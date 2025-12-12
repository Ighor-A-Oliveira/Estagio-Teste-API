# Potencial - Teste Técnico API

API REST de carteira digital desenvolvida como teste técnico para a Potencial.

[![Java 21](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot 3](https://img.shields.io/badge/Spring_Boot-3.3+-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue.svg)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)

## Funcionalidades
- Cadastro e login com CPF
- Criação de conta bancária
- Depósito, saque, transferência interna e externa
- JWT + Refresh Token com rotação
- Validações completas e tratamento de erros
- Testes unitários e de integração
- Documentação Swagger

## Pré-requisitos
| Ferramenta   | Versão mínima | Verificar com       |
|--------------|---------------|---------------------|
| Java JDK     | 21            | `java -version`     |
| Maven        | 3.8+          | `mvn -v`            |
| PostgreSQL   | 15+           | `psql --version`    |

## Configuração do banco (execute uma única vez)
```sql
CREATE DATABASE potencial_test;
CREATE USER spring_user WITH PASSWORD 'strongpassword';
GRANT ALL PRIVILEGES ON DATABASE potencial_test TO spring_user;
```

## Como rodar
- git clone https://github.com/Ighor-A-Oliveira/Potencial-Teste-API.git
- cd SEU_REPOSITORIO
- mvn clean install
- mvn spring-boot:run (ou inicie o metodo principal)
- Aplicação: http://localhost:8080


## Endpoints da API

| Método | Rota                                   | Descrição                              | Auth     |
|--------|----------------------------------------|----------------------------------------|----------|
| **POST** | `/user/register`                     | Cadastra usuário                       | Pública  |
| **POST** | `/user/login`                        | Login → retorna JWT + refresh token     | Pública  |
| **POST** | `/account/register`                  | Cria conta bancária                    | JWT      |
| **POST** | `/transaction/deposit`               | Depósito                               | JWT      |
| **POST** | `/transaction/withdraw`              | Saque                                  | JWT      |
| **POST** | `/transaction/internal-transfer`     | Transferência interna                  | JWT      |
| **POST** | `/transaction/external-transfer`     | Transferência externa (simulada)       | JWT      |

> **Header obrigatório nas rotas protegidas**  
> `Authorization: Bearer <token>`
