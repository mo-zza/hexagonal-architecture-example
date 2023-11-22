# Hexagonal Architecture Example with Spring boot

## Description

This is a simple example of Hexagonal Architecture with Spring boot.

## Spec

- Java 17
- Spring boot 3.1.5
- Gradle 7.2
- Spring Data JPA
- Querydsl
- H2 Database

## Structure

```mermaid
graph LR
    cliet[Client] --> controller[Controller]
    controller --> usecase[UseCase - Port]
    usecase --> service[Service]
    service --> command[Command - Port]
    service --> query[Query - Port]
    command --> persistence[Persistence]
    query --> persistence[Persistence]
    persistence --> repository[Repository - Port]
    repository --> infra[Infrastructure]
```

## Run

```shell
$ ./gradlew bootRun
```