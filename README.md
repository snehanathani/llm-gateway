![Build](https://github.com/snehanathani/llm-gateway/actions/workflows/ci.yml/badge.svg)

# LLM Gateway Skeleton

## Overview
A minimal Spring Boot service that demonstrates an abstraction layer over multiple
LLM providers. The gateway exposes a single REST API while allowing the underlying
LLM implementation to be switched at runtime via configuration.

## Architecture
- `LlmService` — core abstraction
- Provider-specific implementations:
  - OpenAI (via Spring AI)
  - Local stub (cost-free, deterministic)
- Provider selection handled centrally via configuration
- Controllers depend only on the abstraction, not concrete providers

## Features
- Clean `LlmService` interface
- OpenAI (Spring AI) implementation
- Local stub implementation for offline / free usage
- Runtime provider switching via `llm.provider`
- Simple REST API (`POST /generate`)

## Configuration

```properties
# Select provider: local | openai
llm.provider=local

# Default mode (no key required)
llm.provider=local

# To enable OpenAI
export OPENAI_API_KEY=your_key
llm.provider=openai


# Run Locally
./mvnw spring-boot:run


## Provider switching

Set the property `llm.provider` to either:

- `local` — uses the stub implementation (free)
- `openai` — calls OpenAI via Spring AI

Configuration can be provided through:
- `application.properties`
- Environment variables

# example request
curl -X POST http://localhost:8080/generate \
     -H "Content-Type: text/plain" \
     -d "Hello world"

# folder structure

src/main/java
├─ controller/GenerateController.java
├─ service/LlmService.java
├─ service/LocalStubLlmService.java
├─ service/OpenAiLlmService.java
├─ config/LlmServiceConfig.java
