# @EnableJpaRepositories
##  Ativa o repositório customizado para o Spring Data JPA.
##  Esta anotação precisa ser colocada abaixo de @SpringBootapplication que está na classe Application que contém o método "main".
##  @EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class): ativa os repositórios. Apesar de já virem ativados por padrão, mas deve ser colocado para customizar, mudar o repositório base, na verdade. 
