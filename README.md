# Projeto Back-End de E-commerceB2B [![My Skills](https://skillicons.dev/icons?i=spring&theme=)](https://spring.io/projects/spring-boot) [![My Skills](https://skillicons.dev/icons?i=redis&theme=)](https://redis.io/docs/latest/) [![My Skills](https://skillicons.dev/icons?i=postgresql&theme=)](https://www.postgresql.org/)
 
É um projeto Back-End E-commerce B2B desenvolvido com Spring Boot, Spring Security, OAuth2, JWT, SQL (PostgreSQL), NoSQL(Redis). assim empresas e funcionários podem ter acessos seguros e controle refinado de permissões, assim o projeto oferece segurança para a empresa

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Lombok
- OAuth2 
- JWT
- Hibernate
- Maven
- Redis (Gerenciamento de Sessões e Refresh Tokens)
- PostgreSQL (Para guardar dados que não podem ser perdidos)
- Redis Cloud (Gerenciar tokens de acesso e cache)


## Fluxo do projeto

![Fluxo](./E-commerceB2B/visualselection.png)

1. *Autenticação*:
   - O usuário envia suas credenciais (username e password) para o endpoint /authenticate.
   - A API autentica o usuário usando AuthenticationManager.
   - Se as credenciais forem válidas, a API gera um token JWT e um token de atualização.
   - A resposta contém o token JWT, o token de atualização e o email do usuário.

2. *Renovação de Token*:
   - O usuário envia um token de atualização para o endpoint /refresh-token.
   - A API verifica a validade e a expiração do token de atualização.
   - Se o token for válido, a API gera um novo token JWT e o retorna.

3. *Logout*:
   - O usuário envia um token de atualização para o endpoint /logout.
   - A API verifica a validade do token de atualização.
   - Se o token for válido, a API remove o token de atualização do armazenamento, efetivamente deslogando o usuário.

### Exemplo de Fluxo de Autenticação

**Login**

{
  "username": "user1",
  "password": "password123"
}
