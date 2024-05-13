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
### Prototipagem do projeto


## Requisitos funcionais

- O mesmo CPF não pode ser cadastrado para Clientes diferentes;
- O mesmo CNPJ não pode ser cadastrado para Clientes diferentes;
- O mesmo telefone não pode ser cadastrado mais de uma vez;
- Clientes pode cadastrar um ou mais telefones;
- Apenas um telefone principal deve ser cadastrado
- O mesmo email não pode ser cadastrado para Clientes diferentes;

