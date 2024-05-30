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
## Dicionário de dados

Você pode obter um detalhamento a respeito das entidades que compõem esta aplicação [aqui](https://github.com/jairocket/find-your-home/blob/main/docs/bd/diagram/TABLE.png?raw=true).

### Diagrama Entidade Relacionamento 

![](https://github.com/jairocket/find-your-home/tree/main/docs/bd/DD)

## Prototipagem do projeto
Rascunho funcional do produto final para validar a ideia do projeto e dar um vislumbre de como o Find Your Home será.

### Landing Page

![](https://github.com/jairocket/find-your-home/blob/main/docs/Prototypes/Capa.jpeg?raw=true)

![](https://github.com/jairocket/find-your-home/blob/main/docs/Prototypes/Fundo.jpeg?raw=true)

### Pesquisa

![](https://github.com/jairocket/find-your-home/blob/main/docs/Prototypes/Pesquisa.jpeg?raw=true)

### Detalhes

![](https://github.com/jairocket/find-your-home/blob/main/docs/Prototypes/Info_Imovel.jpeg?raw=true)

### Avaliações

![](https://github.com/jairocket/find-your-home/blob/main/docs/Prototypes/Avalaia%C3%A7%C3%B5es.jpeg?raw=true)

## Requisitos funcionais

- O mesmo CPF não pode ser cadastrado para Clientes diferentes;
- O mesmo CNPJ não pode ser cadastrado para Clientes diferentes;
- O mesmo telefone não pode ser cadastrado mais de uma vez;
- Clientes pode cadastrar um ou mais telefones;
- Apenas um telefone principal deve ser cadastrado
- O mesmo email não pode ser cadastrado para Clientes diferentes;

