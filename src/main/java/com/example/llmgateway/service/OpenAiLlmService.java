package com.example.llmgateway.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAiLlmService implements LlmService {

    private final ChatClient chatClient;

    public OpenAiLlmService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generate(String prompt) {
        return this.chatClient.prompt(prompt).call().content();
    }
}
