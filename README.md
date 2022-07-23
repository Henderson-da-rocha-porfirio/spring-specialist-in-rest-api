# Proxy JPA - Uma subclasse instanciada
### - É uma classe que encapsula uma entidade, no nosso caso como exemplo, Kitchen.
### - O JPA instancia esta classe Kitchen dinamicamente em tempo de execução e atribui a kitchen. Ou seja, ao chamar um 'Get', estaremos chamando ele dessa classe que ele criou e não da que queremos que é Kitchen.
### - E isso dá o erro NullPointerException
### - É uma classe que delega os métodos da instância que foi criada 'kitchen', e como não tem nada dentro dela, ele passa para a frente para a Kitchen verdadeira.
### - Exemplo(verificar no console caso dê o erro):
````
com.tuyo.tuyofood.domain.entity.Kitchen$HibernateProxy$ypbKguZB
````
### - É preciso criar um JsonIgnore para ele não serializar:
````
@JsonIgnoreProperties("hibernateLazyInitializer")
````
