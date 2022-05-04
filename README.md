# Trabalhando com Profiles Diferentes
### A vantagem é configurar ambientes diferentes
### 1. Ativando o Profile por linha de comando(exemplo):
````
java -jar target/tuyofood-0.0.1-SNAPSHOT.jar --spring.profiles.active=product
````
### 2. Ativando o Profile por Variável de Ambiente(exemplo):
#### a. Windows:
````
set SPRING_PROFILES_ACTIVE=production
````
#### b. Linux e Mac:
````
export SPRING_PROFILES_ACTIVE=production
````