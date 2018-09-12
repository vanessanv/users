# User

Programa escrito para teste.
Nele foram utilizadas as seguintes tecnologias: Java 1.8, SpringBoot, Rest, JUNIT, MockMvc, Docker e NGINX.

## Getting Started

A API REST do projeto possui o endpoint "/users"  e os seguintes métodos:


GET:
/find/{id} - Retorna o usuário indicado pelo id passado. Ex.:"/users/find/1"

PUT:
/update - Atualiza um usuário existente. 
Ex.:
"/users/update"

{
"id" : "1",
"name" : "Teste",
"cpf": "111.888.666-11",
"email" : "xxx@gmail.com"
}

POST:
/add - Adiciona um usuário.

Ex.:
"/users/add"
{
"id" : "1",
"name" : "Teste",
"cpf": "111.888.666-11",
"email" : "xxx@gmail.com"
}

DELETE:
/delete/{id} - Remove um usuário.

Ex.: 
"/delete/1"
{
"id" : "1",
"name" : "Teste",
"cpf": "111.888.666-11",
"email" : "xxx@gmail.com"
}

### Pré-requisito

Para utilizar a API será necessário o uma aplicação para teste de serviços Web API, como o Postman, por exemplo. Também será necessário ter o Docker instalado.

### Configurando a aplicação para ser utilizada
- Primeiro baixar todo o código do repositório https://github.com/vanessanv/users;
- Acessar o terminal a partir do caminho do projeto baixado e executar o comando docker-compose up;
- Após isso a aplicação já estará disponível através do endpoint: http://localhost:8080/users.


#### Utilizando o Postman para testar a aplicação
Caso a aplicação para teste escolhida seja o Postman, seguir os próximos passos:
- Para testar o método POST, por exemplo:
* Dentro da aba selecionar o método de envio de parâmetro como POST
* Após isso preencher com o seguinte endereço: 
https://localhost:8080/users/add
* Selecionar a opção Body 
* Marcar a opção raw e JSON(application/json)
*Na caixa de texto preencher com o JSON com os dados que quiser testar. Exemplo:
{
"id" : "1",
"name" : "Teste",
"cpf": "111.888.666-11",
"email" : "xxx@gmail.com"
}

* Enviar clicando no botão SEND
* A resposta aparecerá abaixo

- O mesmo deverá ser feito mudando o método de envio para GET, PUT ou DELETE.

### Testes
Os testes unitários são executados automaticamente no momento do build.

## Autora
Vanessa Viana - https://github.com/vanessanv


