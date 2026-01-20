package com.example.llmgateway.service;
import org.springframework.stereotype.Service;
@Service
public class LocalStubLlmService implements LlmService {

    @Override
    public String generate(String prompt) {
        return "LOCAL_MODEL_RESPONSE: " + prompt;
    }
}