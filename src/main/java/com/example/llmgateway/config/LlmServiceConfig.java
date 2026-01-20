package com.example.llmgateway.config;

import com.example.llmgateway.service.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class LlmServiceConfig {

    @Value("${llm.provider}")
    private String provider;

    @Bean
    public LlmService llmService(
            LocalStubLlmService localStub,
            OpenAiLlmService openAi) {

        return switch (provider.toLowerCase()) {
            case "local" -> localStub;
            case "openai" -> openAi;
            default -> throw new IllegalArgumentException(
                "Unknown llm.provider: " + provider);
        };
    }
}