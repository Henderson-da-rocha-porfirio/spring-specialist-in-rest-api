# REST - Representation State Transfer
## - Entendendo antes o que é uma API
## *** API (Application Programming Interface)
````
1. É um software que possui um conjunto de funções que intermediam o acesso as funcionalidades de algum sistema operacional, aplicação ou um serviço.
2. De maneira simples, é uma interface para acessar funcionalidades de um outro sistema.
````
## *** API: PROVEDOR
````
Expor uma função ou uma funcionalidade
````

## *** API: CONSUMIDOR
````
Consome as funções ou as funcionalidades
````

|   CODIGO   | API | SOFTWARE |
|   :---:     |   :---:     | :---:  |
| meu_codigo  | API Collections do Java |Implementação do Collections |
| :---:  | :---: |:---: |

## *** WEB SERVICES (ou WEB API's)
````
São API's WEB. Contudo, nem toda API é WEB.
````
|   CODIGO   | API | SOFTWARE WEB|
|   :---:     |   :---:     | :---:  |
| Disponibilizar Vagas  | API do GlassDoor |GlassDoor |
| :---:  | :---: |:---: |

## *** WEB SERVICES PODEM SER CONSUMIDOS DE VÁRIOS PROVEDORES
````
Aplicação de Agências de Viagens -> Consumindo:
API da CVC
API da Delta
API da Gol
````
## *** MAS O QUE É REST AFINAL?
### 1. É um modelo arquitetural
### 2. É uma especificação que define a forma de comunicação entre componentes de software na web independente da linguagem de programação usada.
### 3. É um estilo arquitetural de desenvolvimento de web services.
### 4. É uma API que segue as melhores práticas de Roy Fielding.

|   SISTEMA A (CLIENT) |     AÇÃO                  | SISTEMA B (SERVER)  |
|   :---:              |     :---:                 |  :---:              |
| CONSUMIDOR           |     REQUISIÇÃO ->         | PROVEDOR  (REST API)|
|   :---:              |     <- RESPOSTA           |  :---:              |

## *** Vantagens de usar Rest API?
### 1. Separação entre Client e Server
### 2. Melhora a escalabilidade
````
Consiste no quão bem um software (e a equipe responsável por ele) conseguem se adaptar para entregar um produto de igual qualidade a um número maior ou menor de clientes, ou em cenários inesperados.
````
### 3. Pode-se utilizar várias linguagens de programação.
### 4. Demanda do mercado. Ou seja, várias empresas fazem uso das API's umas das outras.
### 5. Vários serviços fazem uso de API's cada vez mais em seus sistemas e equipamentos.

## *** CONSTRAINTS - As melhores práticas em REST
### 1. O REST formaliza um conjunto de Constraints:
#### A. Client <-> Server:
##### i. Tem que evoluir separadamente sem qualquer dependência entre eles.
#### B. Stateless:
##### i. Requisição feita ao servidor deve conter tudo que seja necessário para que tudo seja devidamente processado.
##### ii. O servidor não mantém a sessão. Ou seja, o histórico de uso não permanece.
#### C. Cache:
##### i. Melhora a escalabilidade e performance da aplicação por reduzir o número de acessos(hits) no Server.
##### ii. Usar apenas quando necessário
#### D. Interface Uniforme:
##### i. Conjunto de operações bem definidas do sistema
##### ii. Identificação do que o sistema contém através de URI's
##### iii. Uso do protocolo HTTP
##### iv. Uso dos verbos do protocolo HTTP: GET, POST, PUT e DELETE
#### E. Sistema em Camadas:
##### i. Amplia a possibilidade de uso de outros servidores que ficam entre o Client <-> Server
##### ii. Dessa forma, estes servidores oferecem camadas de segurança, cache e etc.
##### iii. E isso não deve interferir entre a requisição(client) e a resposta(server).
#### F. Códigos sob Demanda:
##### i. Ela é opcional.
##### ii. O Server pode enviar como resposta de uma requisição algum código que deve ser executado no Client.
##### iii. Por exemplo, um Server pode retornar um Javascript para o Client que é responsável por montar um gráfico.

## *** REST VERSUS RESTful API
### 1. REST: É o estilo arquitetural que possui as Constraints. Isto é, a especificação.
### 2. RESTful API: É uma API desenvolvida em conformidade 100% com as Constraints.

## *** PROTOCOLO HTTP
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

### - COMPOSIÇÃO DA RESPOSTA
````
 [HTTP/[VERSÃO] [STATUS]   ->         HTTP/1.1 201 Created
 
 [CABEÇALHOS]              ->         Content-Type: application/json
																				
										{ 
											"codigo": 322,
											"nome": "Notebook i5",\
 [CORPO]		           ->			    "preco": 2100.0
										}
 						
````

## ***  REST  RESOURCES
### 1. Singleton Resource: Coleção de Produtos é Um Recurso
### 2. Identificando Recursos: URI ( Uniform Resource Identifier ): dá endereço aos recursos
### 3. URI vs URL:
````
URL ( Uniform Resource Locale ) = é um tipo de URI. Identifica o Identificador e também a Localização do recurso

````
### 4. A URI deve se referenciar a um substantivo ou alguma coisa e não a um verbo. Porque coisas possuem propriedades e verbos não possuem.
#### Errado:
````
/listarProdutos
````
#### Certo:
````
/produtos
````

### 5. É importante usar no plural: /produtos{codigo}
````
/produtos/223
````

## *** Métodos HTTP
## - Entender antes Idempotência e Safe Method
## ** IDEMPOTÊNCIA
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
