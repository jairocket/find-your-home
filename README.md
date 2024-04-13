# find-your-home
É um site para encontrar sua casa nova. Você também pode vender ou alugar sua casa.


## Infraestrutura

### Instale o Docker e o Docker-Compose

### Crie um contêiner com uma instância de banco de dados Postgres
```
docker-compose up
```
### Verifique se o contêiner foi criado
```
docker ps -a
```
### Para parar o contêiner
```
docker-compose down
```
### Execute a aplicação
```
mvn spring-boot:run
```