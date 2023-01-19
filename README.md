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

### 2 - O Spring suporta a anotação @Component desde de sua versão 2.5, e a mesma serve para indicar ao framework que aquela classe é um bean que deverá ser administrado pela implementação de IoC Container do Spring.
#### - A anotação @Component é um estereótipo, e as especializações dele são @Repository, @Service e @Controller.

#### - Quando uma classe é anotada com @Component significa que a mesma usará o padrão de injeção de depêndencia, e será elegível para auto-configuração e auto-detecção de beans anotados à partir de escaneamento de classpath que o IoC Container do Spring faz.

#### - Ao carregar a aplicação, o Spring escanea o classpath atrás de classes anotadas com @Component ou especializações para então criar uma instância com escopo do tipo singleton por padrão, ou seja, os beans são stateless (não devem guardar estado), assim não sendo necessário uma nova instância do bean a cada vez que houver uma referência.

### 3 - O Spring só escaneará os beans elegíveis que você especificar no arquivo applicationContext.xml, dessa forma:
````
<context:component-scan base-package="com.path.dos.beans" />
````
### 4 - Uso prático: A anotação @Component deve ser usada em nível de classe, dessa forma:
````
@Component
public class Foo {
//implementação da  classe
}
````
### 5 - Para referenciar a mesma em outro contexto (obter a instância), pode se usar a anotação @Autowired, dessa forma:
````
@Component
public class Bar {
   @Autowired
   private Foo foo;
}
````
