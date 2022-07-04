# @Lazy
## informa ao Container do Spring que só instancie as dependências injetadas no momento que for preciso. Isso evita o erro de dependência circular.
## * Dependência Circular:
````
 é quando a classe RestaurantRepositoryImpl, é instanciada pelo container do Spring, ela vê
 as dependências que precisa, e instancia as dependências. Só que como a dependência é RestaurantRepository, e esse vai instanciar o
 RestaurantRepositoryImpl, ele fica nessa dependência circular.
 ````
