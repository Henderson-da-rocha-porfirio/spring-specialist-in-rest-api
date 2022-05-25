# IDEMPOTÊNCIA
````
Algo idempotente tem a capacidade de ser utilizado mais de uma vez sem que o resultado da primeira aplicação se altere.
````
## ** EXEMPLO DE IDEMPOTÊNCIA
### Vendendo um Abacaxi
#### 1. Consultando:
````
Todas vezes que alguém perguntar o preço do Abacaxi e eu responder 3 reais todas as vezes.
Ou seja, o preço dele não muda só porque alguém está perguntando.

````

#### 2. Alterando:
````
Mudando o preço do abacaxi pode ser alterado várias vezes para 2 reais, e isso não altera o resultado.

````

### - COMPOSIÇÃO DA REQUISIÇÃO
````
 [MÉTODO][URI] HTTP/[VERSÃO]    ->         POST /produtos HTTP/1.1 
 
 [CABEÇALHOS]                   ->           Content-Type: application/json
										Accept: application/json|
										
										{ 
											"nome": "Notebook i5",\
 [CORPO/PAYLOAD]		        ->			"preco": 2100.0
										}
 						
````

## ** SAFE METHOD
````
É um método que não modifica recursos (resources)

````

## ** PRINCIPAIS MÉTODOS HTTP

### 1. GET - Obter a representação do recurso (resource) de uma coleção de recursos.
##### - O get sendo executado, o resultado sempre será o mesmo e não gerará efeito colateral. Ele é um método idempotente e safe method.

#### i. Requisição:
````
GET /produtos HTTP/1.1 

{ 

	"preco": 2100.0
}									

````

#### ii. Resposta
````
HTTP/1.1 	200 OK	

{ 

	"codigo": 9,
	"preco": 2100.0

}							

````

										
### 2. POST - Usado para criar um novo recurso (resource) dentro de uma coleção de recursos.
##### - O Post sendo executado constantemente, o resultado sempre será diferente e gerará efeito colateral. Ele não é um método idempotente e nem safe method.
#### i. Requisição:
````
POST /produtos HTTP/1.1 

{ 

	"preco": 2100.0
}									

````

#### ii. Resposta
````
HTTP/1.1 	201 Created

{ 

	"codigo": 9,
	"preco": 2100.0

}							

````


### 3. PUT - Usado para atualizar um determinado recurso (resource) dentro de uma coleção de recursos.
##### - O Put atualiza o recurso completo. Ele também atualiza ou cria caso não exista. Ele é um método idempotente e não é safe method.
#### i. Requisição:
````
PUT /produtos/9  HTTP/1.1 

{ 

	"preco": 2100.0
}									

````

#### ii. Resposta
````
HTTP/1.1 	200 OK	

{ 

	"codigo": 9,
	"preco": 2100.0

}							

````


### 4. PATCH - Usado para atualizar um determinado recurso (resource) parcialmente dentro de uma coleção de recursos.
##### - O Patch atualiza parcialmente o recurso. Ele é um método idempotente e não é safe method.
#### i. Requisição:
````
PATCH /produtos/7  HTTP/1.1 

{ 

	"preco": 2000
}									

````

#### ii. Resposta
````
HTTP/1.1 	200 OK	

{ 

	"codigo": 7,
	"nome": "Pink",
	"preco": 2100.0

}							

````

### 5. DELETE - Usado para remover um determinado recurso (resource) dentro de uma coleção de recursos.
##### - O Delete remove um determinado recurso. Ele é um método idempotente e não é safe method.
#### i. Requisição:
````
DELETE /produtos/7  HTTP/1.1 

````

#### ii. Resposta
````
HTTP/1.1 	204 No Content						

````

### 6. HEAD - Obter a representação do recurso (resource) de uma coleção de recursos mas não retorna o corpo na resposta.
##### - O Head é usado apenas para buscar o cabeçalho.

#### i. Requisição:
````
HEAD /produtos/2 HTTP/1.1									

````

#### ii. Resposta
````
HTTP/1.1 	200 OK	
Content-Type: application/json

[ SEM CORPO ]							

````

### 7. OPTIONS - Ele não tem nenhuma relação com criar, alterar, modificar ou excluir recursos (resource).
##### - O Options é usado apenas para solicitar uma lista de métodos.

#### i. Requisição:
````
OPTIONS /produtos/2 HTTP/1.1									

````

#### ii. Resposta
````
HTTP/1.1 	200 OK	
Allow: GET, PUT, DELETE							

````
