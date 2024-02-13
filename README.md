# Women's World Cup 2023: A Koltin RESTful API

Este é um projeto que visa fornecer informações sobre a Copa do Mundo de Futebol Feminino de 2023. O projeto inclui uma API em Kotlin que permite o acesso aos dados das seleções participantes e integração com o ChatGPT-4 para simular as partidas da Copa e prever os resultados dos jogos.

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
     <a alt="Kotlin">
        <img src="https://img.shields.io/badge/Kotlin-v1.8.22-purple.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.1.1-brightgreen.svg" />
    </a>
    <a alt="Spring Cloud">
        <img src="https://img.shields.io/badge/Spring%20Cloud-v4.0.3-brightgreen.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.1.214-darkblue.svg" />
    </a>
</p>

## Configuração

Essas instruções fornecerão aos usuários as etapas necessárias para clonar o repositório e iniciar a aplicação em
diferentes ambientes (Unix e Windows) com o perfil de desenvolvimento ativado.

1. Clone o repositório: git clone `https://github.com/samuel-prazeres-junior/womens-world-cup-2023.git`
2. Inicie a aplicação no ambiente Unix: `./gradlew bootrun --args='--spring.profiles.active=dev'`
3. Inicie a aplicação no ambiente Windows: `gradle.bat bootrun --args='--spring.profiles.active=dev'`

## Uso da API

> Request

### Simular partida entre dois times:

- Método: `GET`
- Endpoint: `/simulate/{team1Id}/{team2Id}`

Parâmetros de caminho:
- `{team1Id}`: ID da primeira equipe.
- `{team2Id}`: ID da segunda equipe.

- Exemplo de solicitação:

```http
GET /simulate/ARG/BRA
```

> Response

- Código de resposta: `200 OK`
- Corpo da resposta: `TeamDto` contendo os dados da equipe vencedora.

Exemplo de resposta:

```json
{
  "id": "ARG",
  "name": "Argentina",
  "score": 1682.45
}
```

#### Códigos de resposta possíveis:

- `200 OK`: A simulação foi concluída com sucesso e a equipe vencedora é retornada.
- `422 Unprocessable Entity`: Uma ou ambas as equipes não foram encontradas na Copa do Mundo Feminina.

## Documentação do Swagger

A documentação da API pode ser encontrada no Swagger. Para visualizá-la,
acesse: [Documentação do Swagger](http://localhost:8080/swagger-ui/index.html#/).
