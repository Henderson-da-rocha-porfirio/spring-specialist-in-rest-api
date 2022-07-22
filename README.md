# Nullable
### nullable = false: significa not null no database.
### Mostra que as propriedades são obrigatórias. E ainda as usamos porque ainda estamos utilizando o "generate ddl" para gerar o banco de dados automaticamente. E isso também faz com que ele crie a uma coluna "notNull".
### Ele põe por padrão um 'true' se não for especificado com 'false'.
### E independente se estiver com um Generate DDL ou não, é importante colocá-lo como 'false' para ele saber quando gerar um inner join, um left join e etc.
