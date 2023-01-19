# @Component

### 1 - De acordo com a própria definição dos criadores, ela representa um componente (bean) que é detectado automaticamente quando trabalhamos com configurações baseadas em annotations e busca de caminhos de classes.
### Outros elementos, como @Repository, @Service e @Controller, são alguns estereótipos que implementam a @Component. Dessa forma, você pode criar uma outra especialização de @Component de acordo com a sua necessidade.

#### Exemplo:
````
@Component
@Scope("prototype")
public @interface MinhaClasse{
...
}
````
### Dessa forma, temos uma nova especialização de @Component.
