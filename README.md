# ColumnDefinition
## Mostra a precisão de uma coluna padrão.

### 1. Ao criar uma entidade
#### A primeira maneira de definir um valor de coluna padrão é defini-lo diretamente como um valor de propriedade de entidade :
````
@Entity
public class User {
    @Id
    private Long id;
    private String firstName = "John Snow";
    private Integer age = 25;
    private Boolean locked = false;
}
````
#### Agora, toda vez que criamos uma entidade usando o novo operador, ele definirá os valores padrão que fornecemos:
````
@Test
void saveUser_shouldSaveWithDefaultFieldValues() {
    User user = new User();
    user = userRepository.save(user);
    
    assertEquals(user.getName(), "John Snow");
    assertEquals(user.getAge(), 25);
    assertFalse(user.getLocked());
}
````
#### Há uma desvantagem para esta solução.

#### Quando damos uma olhada na definição da tabela SQL, não veremos nenhum valor padrão nela:
````
create table user
(
    id     bigint not null constraint user_pkey primary key,
    name   varchar(255),
    age    integer,
    locked boolean
);
````
#### Portanto, se os substituirmos por null , a entidade será salva sem nenhum erro :
````
@Test
void saveUser_shouldSaveWithNullName() {
    User user = new User();
    user.setName(null);
    user.setAge(null);
    user.setLocked(null);
    user = userRepository.save(user);

    assertNull(user.getName());
    assertNull(user.getAge());
    assertNull(user.getLocked());
}
````
### 2. Na Definição do Esquema
#### Para criar um valor padrão diretamente na definição da tabela SQL , podemos usar a anotação @Column e definir seu parâmetro columnDefinition :
````
@Entity
public class User {
    @Id
    Long id;

    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;

    @Column(columnDefinition = "integer default 25")
    private Integer age;

    @Column(columnDefinition = "boolean default false")
    private Boolean locked;
}
````
#### Usando este método, o valor padrão estará presente na definição da tabela SQL:
````
create table user
(
    id     bigint not null constraint user_pkey primary key,
    name   varchar(255) default 'John Snow',
    age    integer      default 35,
    locked boolean      default false
);
````
#### E a entidade será salva corretamente com os valores padrão:
````
@Test
void saveUser_shouldSaveWithDefaultSqlValues() {
    User user = new User();
    user = userRepository.save(user);

    assertEquals(user.getName(), "John Snow");
    assertEquals(user.getAge(), 25);
    assertFalse(user.getLocked());
}
````
### Lembre-se de que , usando esta solução, não poderemos definir uma determinada coluna como  nula ao salvar a entidade pela primeira vez. Se não fornecermos nenhum valor, o valor padrão será definido automaticamente.

### Fonte: [Baeldung](https://www.baeldung.com/jpa-default-column-values)
