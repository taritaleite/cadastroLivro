
# DESAFIO TÉCNICO COM JAVA E SPRING BOOT

## Sobre o Projeto
Desenvolvimento de uma API de Cadastro de Livros para participar de um desafio técnico do Banco Itaú, assim como para aprimoraro conhecimento sobre Java e Spring Boot.

## Tecnologias utilizadas

Java  
Maven  
Banco de Dados em Memória - H2  
Junit 5  
Mock MVC  
Mockito

## Diagrama da Aplicação
![Diagrama](https://raw.githubusercontent.com/taritaleite/cadastroLivro/main/img/Diagrama.png)

## Exemplo de Retorno das Rotas

#### [GET] /livros

Exemplo:  
/livros  
Retorno  
Status: 200 OK

```json

 [
	{
		"id": 1,
		"titulo": "Clean Code: A Handbook of Agile Software Craftsmanship",
		"edicao": "1ª",
		"isbn": "978-0132350884",
		"categoria": "TECNOLOGIA"
	},
	{
		"id": 2,
		"titulo": "Cracking the Coding Interview: 189 Questões de Programação e Soluções",
		"edicao": "6ª",
		"isbn": "978-0984782857",
		"categoria": "TECNOLOGIA"
	},
	{
		"id": 3,
		"titulo": "Anatomia para Estudantes: Texto e Atlas Colorido",
		"edicao": "3ª",
		"isbn": "978-8535263553",
		"categoria": "MEDICINA"
	},
	{
		"id": 4,
		"titulo": "Robbins & Cotran: Patologia: Bases Patológicas das Doenças",
		"edicao": "10ª",
		"isbn": "978-8535285043",
		"categoria": "MEDICINA"
	},
	{
		"id": 5,
		"titulo": "O Que é Justiça?",
		"edicao": "2ª",
		"isbn": "978-8532634227",
		"categoria": "DIREITO"
	},
	{
		"id": 6,
		"titulo": "Introdução ao Estudo do Direito: Técnica, Decisão, Dominação",
		"edicao": "1ª",
		"isbn": "978-8520347414",
		"categoria": "DIREITO"
	}
]

```

#### [GET]/livros/{Id}

Exemplo:  
/livros/{Id}  
Retorno  
Status: 200 OK

```json
{
	"id": 1,
	"titulo": "Clean Code: A Handbook of Agile Software Craftsmanship",
	"edicao": "1ª",
	"isbn": "978-0132350884",
	"categoria": "TECNOLOGIA"
}

```
#### [Post]/livros/

Exemplo:  
Headers  
Content-Type = application/json

```json
{
  "titulo": "Projeto Livro: Desenvolvendo Software com Qualidade",
  "edicao": "2ª edição",
  "isbn": "978-1234567890",
  "categoria": "TECNOLOGIA"
}
```
Exemplo:    
Retorno  
Status: 201 CREATED

```json
{
  "titulo": "Projeto Livro: Desenvolvendo Software com Qualidade",
  "edicao": "2ª edição",
  "isbn": "978-1234567890",
  "categoria": "TECNOLOGIA"
}
```

#### [PUT]/livros/1

Exemplo:  
Headers  
Content-Type = application/json

```json
{
	"edicao": "2ª",
	"categoria": "MEDICINA"
}
```
Exemplo:    
Retorno  
Status: 200 OK

```json
{
	"id": 1,
	"titulo": "Clean Code: A Handbook of Agile Software Craftsmanship",
	"edicao": "2ª",
	"isbn": "978-0132350884",
	"categoria": "MEDICINA"
}
```

### Códigos de erros
404 Not Found: Livro não encontrado para o ID: 1, digite um ID válido.


### Autora

[Tarita Leite](https://www.linkedin.com/in/taritaleite/)



