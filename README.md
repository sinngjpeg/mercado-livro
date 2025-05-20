# 📚 mercado-livro

Projeto desenvolvido com **Spring Boot** e **Kotlin** que simula um serviço de **venda e compra de livros**. A aplicação tem como objetivo representar um sistema simples de marketplace de livros, com funcionalidades como cadastro de usuários, livros, compra, administração e controle de status dos pedidos.

> 🚀 Este projeto utiliza **Java 17** como versão da JVM.

---

## 🛠️ Tecnologias Utilizadas

- [Kotlin](https://kotlinlang.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security) *(opcional)*
- [H2 Database](https://www.h2database.com/) *(ou outro banco)*
- [Flyway](https://flywaydb.org/) *(opcional)*
- [JUnit5](https://junit.org/junit5/) e [MockK](https://mockk.io/)
- [Gradle](https://gradle.org/)

---

## 📦 Requisitos

- Java 17+
- Gradle 7+
- IDE como IntelliJ IDEA ou VS Code

---

## ▶️ Como rodar o projeto

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/mercado-livro.git
cd mercado-livro

./gradlew bootRun

Acesse no navegador: http://localhost:8080

src/
├── main/
│   ├── kotlin/
│   │   └── com/seunome/mercadolivro/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── MercadoLivroApplication.kt
│   └── resources/
│       ├── application.yml
│       └── data.sql
└── test/
    └── kotlin/...
````

## 📌 Funcionalidades previstas

- ✅ **Cadastro de clientes**  
  Permite registrar novos clientes com dados pessoais e status ativo/inativo.

- ✅ **Cadastro de livros**  
  Criação de livros vinculados a clientes, com informações como título, autor, preço e status.

- ✅ **Compra de livros**  
  Simulação de uma compra com múltiplos livros por cliente.

- 🔄 **Controle de status dos pedidos**  
  Atualização dos pedidos conforme etapas como: pago, cancelado, enviado, entregue.

- 🧪 **Integração com sistema de pagamento (mockado)**  
  Simulação de uma integração com um gateway de pagamento para validar compras.

- 🔐 **Autenticação e autorização de usuários**  
  Implementação de controle de acesso com Spring Security (em andamento).

## 🤝 Contribuição

Sinta-se à vontade para **abrir issues** e **enviar pull requests**.  
Toda ajuda é muito bem-vinda para melhorar este projeto! 💡🚀

---

## 📝 Licença

Este projeto está licenciado sob a **Licença MIT**.  
Consulte o arquivo [`LICENSE`](LICENSE) para mais detalhes.