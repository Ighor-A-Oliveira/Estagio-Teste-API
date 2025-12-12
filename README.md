Markdown# Potencial - Teste Técnico API

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
| Ferramenta   | Versão mínima | Verificar com         |
|--------------|---------------|-----------------------|
| Java JDK     | 21            | `java -version`       |
| Maven        | 3.8+          | `mvn -v`              |
| PostgreSQL   | 15+           | `psql --version`      |

## Configuração do banco (execute uma única vez)
```sql
CREATE DATABASE potencial_test;
CREATE USER spring_user WITH PASSWORD 'strongpassword';
GRANT ALL PRIVILEGES ON DATABASE potencial_test TO spring_user;
Como rodar
Bashgit clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
cd SEU_REPOSITORIO
mvn clean install
mvn spring-boot:run
Aplicação: http://localhost:8080
Swagger: http://localhost:8080/swagger-ui.html
Endpoints da API

  
    POST /user/register


    Cadastro de usuário

    name, cpf, password
  
  
    POST /user/login


    Login com CPF e senha

    Retorna access + refresh token
  
  
    POST /account/register


    Cria conta bancária

    JWT obrigatório
  
  
    POST /transaction/deposit


    Realiza depósito
  
  
    POST /transaction/withdraw


    Realiza saque
  
  
    POST /transaction/internal-transfer


    Transferência entre contas da mesma instituição
  
  
    POST /transaction/external-transfer


    Transferência para outro banco (simulada)
  

Todos os endpoints protegidos precisam do header:
Authorization: Bearer <seu_token_jwt>
Testes
Bashmvn test
Pronto. Agora é só fazer os 6 passos acima e seu README vai ficar lindo na hora.
Se quiser que eu troque SEU_USUARIO e SEU_REPOSITORIO pelos nomes reais, é só me mandar o link do GitHub que eu faço em 3 segundos e te mando o texto já 100% certinho.
Você vai arrasar no processo!
