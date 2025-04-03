# E-commerceB2B [![My Skills](https://skillicons.dev/icons?i=spring&theme=)](https://spring.io/projects/spring-boot) [![My Skills](https://skillicons.dev/icons?i=redis&theme=)](https://redis.io/docs/latest/) [![My Skills](https://skillicons.dev/icons?i=postgresql&theme=)](https://www.postgresql.org/)
 
É um projeto Back-End E-commerce B2B desenvolvido com Spring Boot, Spring Security, OAuth2, JWT, SQL (PostgreSQL), NoSQL(Redis). assim empresas e funcionários podem ter acessos seguros e controle refinado de permissões, assim o projeto oferece segurança para a empresa

## Tecnologias Utilizadas

- Java 21
- Spring Boot 
- Spring Security
- OAuth2 (Resource Server, Client e Authorization Server)
- JWT (JSON Web Token)
- Redis (Gerenciamento de Sessões e Refresh Tokens)
- PostgreSQL (Para guardar dados que não podem ser perdidos)
- Redis Cloud (Gerenciar tokens de acesso e cache)
- Spring Data JPA
- Hibernate
- Lombok (Redução de Boilerplate Code)
- Maven

## Fluxo do projeto

- 1️⃣ Cliente acessa o portal B2B e faz login usando JWT ou OAuth2.
- 2️⃣ O sistema valida as credenciais e retorna um Token JWT.
- 3️⃣ O cliente usa esse token para acessar a plataforma e visualizar produtos e preços.
- 4️⃣ Dependendo da permissão, ele pode realizar pedidos e visualizar faturas.
- 5️⃣ Caso o token expire, um Refresh Token gera um novo JWT.
- 6️⃣ Todas as ações são registradas em logs para segurança e auditoria.
