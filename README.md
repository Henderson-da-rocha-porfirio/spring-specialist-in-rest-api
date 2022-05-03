# Injeção de Dependência: Métodos de CallBack
## Mostrando o ciclo de vida dos Beans
### Duas Formas para a Configuração
#### 1. Usando anotações do Java:
````
 @PostConstruct e @PreDestroy
````
#### 2. Usando uma classe Config:
````
@Bean(initMethod = "init", destroyMethod = "destroy")
````