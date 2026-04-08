# 📚 Sistema de Gerenciamento de Biblioteca

API REST desenvolvida com Spring Boot para gerenciamento de livros em uma biblioteca.

---

## 🚀 Funcionalidades

- Cadastro de livros
- Listagem de todos os livros
- Busca por ISBN
- Busca por título
- Remoção de livros
- Controle de estoque (entrega de livros)
- Validações:
    - ISBN não pode ser duplicado
    - Não permite retirar mais livros do que o estoque disponível

---

## 🛠️ Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Maven

---

## 📌 Endpoints

### Cadastrar livro
POST /livros

Exemplo:
{
"titulo": "Dom Casmurro",
"autor": "Machado de Assis",
"isbn": "123",
"anoPublicacao": 1899,
"estoque": 5
}

---

### Listar todos
GET /livros

---

### Buscar por ISBN
GET /livros/isbn/{isbn}

---

### Buscar por título
GET /livros/titulo?titulo=nome

---

### Remover livro
DELETE /livros/{isbn}

---

### Entregar livro (baixar estoque)
POST /livros/{isbn}/entregar

Exemplo:
{
"quantidade": 2
}

---

## ⚙️ Como rodar o projeto

git clone https://github.com/marcosfernandesg/gerenciamento-biblioteca
cd gerenciamento-biblioteca
mvn spring-boot:run

A aplicação estará disponível em:
http://localhost:8080/livros

---

## 🧪 Banco de Dados

O projeto utiliza o banco em memória H2.

- Os dados são apagados ao reiniciar a aplicação
- Ideal para testes e desenvolvimento

---

## 👨‍💻 Autor

Marcos Guilherme Fernandes Pereira
