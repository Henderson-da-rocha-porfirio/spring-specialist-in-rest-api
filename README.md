# Injeção de Dependência: Usando o Spring Profiles

### Duas Formas para a Configuração do Profile:
#### 1. @Profile + application.properties: Serve para mostrar a mudança de ambiente:
````
spring.profiles.active=prod,mysql,filesystem
ou
spring.profiles.active=dev,postgresql,S3
ou
spring.profiles.active=prod
ou
spring.profiles.active=dev
````
#### 2. Configurando pela VM options:
##### a. Vá em Run Configuration(onde se faz a modificação da configuration)
##### b. Edit Configurations
##### c. Modify options
##### d. Em Java, selecione Add VM options
##### e. Adicionar o perfil que deseja com o comando:
````
-Dspring.profiles.active=dev
 ou 
-Dspring.profiles.active=prod
````
##### e. 'dev' ou 'prod' estão apenas como exemplo.
### Será utilizado um Mock (objeto que serve para simulação para testar o comportamento de outros objetos).