# mini-agro

Aplicação de registro de produção de fazendas, com comodites de grãos.
Aplicação composta por um Backend com Spring Boot e MongoDB, e também,
por um Frontend simples com Angular.

## Getting started

### Passo 1:

Fazer um clone do projeto:

```json
git clone https://github.com/Ladgelson/mini-agro.git
```

### Passo 2:
Criar banco de dados MongoDB com o docker na raiz do projeto:
```json
docker-compose up -d
```

### Passo 3: 
Abrir pasta do backend, baixar dependencias do Maven e rodar aplicação Spring Boot.
Para verificar Swagger da aplicação:

```json
http://localhost:8081/swagger-ui/index.html
```

### Passo 4:
Baixar dependencia do projeto com o comando:

```json
npm i
```

### Passo 5:
Rodar aplicação Angular com o comando:
```json
ng serve
```

### Passo 6:
Verificar frontend da aplicação em:

```json
http://localhost:4200/
```