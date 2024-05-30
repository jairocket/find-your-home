# find-your-home
É um site para encontrar sua casa nova. Você também pode vender ou alugar sua casa.

## Desenvolvido com :coffee: por:

- Everton Mutti
- Gustavo Lopes
- Isadora Moura
- Jailson Anjos
- Júlia Amorim
  
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

Você pode obter um detalhamento a respeito das entidades que compõem esta aplicação [aqui](https://github.com/jairocket/find-your-home/tree/main/docs/bd/DD).

### Diagrama Entidade Relacionamento 

![](https://github.com/jairocket/find-your-home/blob/main/docs/bd/diagram/TABLE.png?raw=true)

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

- Deve ser possível cadastrar clientes
- Deve ser possível listar clientes
- Deve ser possível editar o nome e o email dos clientes cadastrado
- Deve ser possível deletar um cliente cadastrado
- O CPF e o CNPJ dos Clientes não podem ser cadastrados mais de uma vez;
- O CPF deve ter o formato "xxx.xxx.xxx-xx";
- O CNPJ deve ter o formato "xx.xxx.xxx/xxxx-xx"
- O mesmo Telefone não pode ser cadastrado mais de uma vez;
- Clientes pode cadastrar um ou mais Telephones;
- Apenas um Telefone principal deve ser cadastrado por Clientes;
- O mesmo email não pode ser cadastrado para Clientes diferentes;
- Deve ser possível cadastrar um Imóvel;
- Deve ser possível editar dados de um Imóvel;
- Deve ser possível deletar um Imóvel;
- Deve ser possível listar os Anúncios;
- Deve ser possĩvel cadastrar Anúncios novos;
- Deve ser possível deletar Anúncios de forma lógica;
- Deve ser possível editar um Anúncio;
- Deve ser possível alterar o status de um Anúncio;
- Deve ser possível filtrar Anúncios pelo respectivo status;

## Estrutura do front-end do projeto
```
/src
  /components   # Componentes reutilizáveis
  /pages        # Páginas do aplicativo
  /assets       # Imagens, ícones, etc.
App.css       # Arquivos de estilos (CSS, SCSS)
App.js        # Componente raiz
index.js      # Ponto de entrada do aplicativo
``` 
### Instruções básicas para iniciar o projeto localmente.
```
npm start
```
### Scripts Disponíveis

Lista dos scripts que podem ser executados com `npm` ou `yarn`.

### Tecnologias Utilizadas
- React
- React Router
- Axios
- Componentes estilizados e Móulos CSS

### Link para o repositório front-end 
https://github.com/KaKeeM/WebContent 

