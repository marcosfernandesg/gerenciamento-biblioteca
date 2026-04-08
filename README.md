# 📚 Sistema de Gerenciamento de Biblioteca

API REST desenvolvida com Spring Boot para gerenciamento de livros em uma biblioteca.

## 🚀 API Online
https://gerenciamento-biblioteca-production.up.railway.app/livros

## 🧠 Descrição
Esta aplicação permite o gerenciamento completo de um catálogo de livros, incluindo cadastro, consulta, remoção e controle de estoque.

## ⚙️ Funcionalidades
- Cadastro de livros  
- Listagem de todos os livros  
- Busca por ISBN  
- Busca por título  
- Remoção de livros  
- Controle de estoque (entrega de livros)  

## ⚠️ Regras de Negócio
- Não é permitido cadastrar livros com ISBN duplicado  
- Não é permitido retirar mais livros do que o disponível em estoque  

## 🛠️ Tecnologias
- Java 21  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  
- Lombok  

## 📌 Endpoints

Cadastrar livro  
POST /livros  
Body:
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "isbn": "123",
  "anoPublicacao": 1899,
  "estoque": 5
}

Listar todos  
GET /livros  

Buscar por ISBN  
GET /livros/isbn/{isbn}  

Buscar por título  
GET /livros/titulo?titulo=nome  

Remover livro  
DELETE /livros/{isbn}  

Entregar livro  
POST /livros/{isbn}/entregar  
Body:
{
  "quantidade": 2
}

## 🧪 Como testar
A API pode ser testada utilizando:
- Postman  
- Insomnia  
- Navegador (requisições GET)  

## ⚙️ Como rodar localmente
git clone https://github.com/marcosfernandesg/gerenciamento-biblioteca  
cd gerenciamento-biblioteca  
mvn spring-boot:run  

A aplicação estará disponível em:  
http://localhost:8080  

## 🧪 Banco de Dados
O projeto utiliza o banco H2:
- Em memória/local  
- Ideal para testes  
- Os dados podem ser reiniciados ao reiniciar a aplicação  

## 👨‍💻 Autor
Marcos Guilherme Fernandes Pereira
