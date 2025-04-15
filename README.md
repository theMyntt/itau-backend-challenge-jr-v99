# Itaú Backend Challenge for Júnior Engineers (Job Apply 99)

- Built in Java 21
- Built in SpringBoot 3.4.4

## Dependencies

- Maven
- Java 21

## Challenge

- You can read about the challenge [here](./CHALLENGE.md)

## Architecture

In this Challenge, I used Hexagonal Architecture with Domain Driven Design Patter and Clean Architecture fundamentals 

Example:
- `Controller -> UseCase`: Controller sends a `UseCaseInput` to `UseCase`
- `UseCase -> Port`: `UseCase` sends a `PortInput` to the `Port`
- `Adapter -> Repository`: `Adapters` calls a `Mapper` to transform an `entity` to `tableRow` and sends to `Repository`