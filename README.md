# Projeto Potencial-Teste-API - Configuração Local

Esta seção guia como clonar o projeto e preparar a execução local usando Java, Maven e PostgreSQL.

---

## 📋 Pré-requisitos e Preparação Local

Antes de começar, certifique-se de ter instalado:

1. **Java JDK 21**  
   Verifique com: `java -version`

2. **Maven**  
   Para compilar e rodar o projeto: `mvn -v`

3. **PostgreSQL 18**  
   - Banco de dados: `security_test`  
   - Usuário: `spring_user`  
   - Senha: `strongpassword`  

Caso não existam, crie-os usando SQL:

```sql
CREATE DATABASE security_test;
CREATE USER spring_user WITH PASSWORD 'strongpassword';
GRANT ALL PRIVILEGES ON DATABASE security_test TO spring_user;
sql```


1. Preparando o Projeto Localmente

Clonar o Repositório
git clone https://github.com/seu-usuario/seu-repositorio.git](https://github.com/Ighor-A-Oliveira/Potencial-Teste-API.git
cd seu-repositorio\



2. Configurar o Banco de Dados

No arquivo src/main/resources/application.properties já existem as configurações do banco:

spring.datasource.url=jdbc:postgresql://localhost:5432/security_test
spring.datasource.username=spring_user
spring.datasource.password=strongpassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

  Se o banco ou usuário não existirem, crie-os usando SQL:

```sql
CREATE DATABASE security_test;
CREATE USER spring_user WITH PASSWORD 'strongpassword';
GRANT ALL PRIVILEGES ON DATABASE security_test TO spring_user;


Compilar o Projeto

Dentro da pasta do projeto:

mvn clean install

Executar a aplicação:

mvn spring-boot:run

ou executa a classe principal
