# CONSTRAINTS - As melhores práticas em REST
### 1. O REST formaliza um conjunto de Constraints:
#### A. Client <-> Server:
##### i. Tem que evoluir separadamente sem qualquer dependência entre eles.
#### B. Stateless:
##### i. Requisição feita ao servidor deve conter tudo que seja necessário para que tudo seja devidamente processado.
##### ii. O servidor não mantém a sessão. Ou seja, o histórico de uso não permanece.
#### C. Cache:
##### i. Melhora a escalabilidade e performance da aplicação por reduzir o número de acessos(hits) no Server.
##### ii. Usar apenas quando necessário
#### D. Interface Uniforme:
##### i. Conjunto de operações bem definidas do sistema
##### ii. Identificação do que o sistema contém através de URI's
##### iii. Uso do protocolo HTTP
##### iv. Uso dos verbos do protocolo HTTP: GET, POST, PUT e DELETE
#### E. Sistema em Camadas:
##### i. Amplia a possibilidade de uso de outros servidores que ficam entre o Client <-> Server
##### ii. Dessa forma, estes servidores oferecem camadas de segurança, cache e etc.
##### iii. E isso não deve interferir entre a requisição(client) e a resposta(server).
#### F. Códigos sob Demanda:
##### i. Ela é opcional.
##### ii. O Server pode enviar como resposta de uma requisição algum código que deve ser executado no Client.
##### iii. Por exemplo, um Server pode retornar um Javascript para o Client que é responsável por montar um gráfico.
