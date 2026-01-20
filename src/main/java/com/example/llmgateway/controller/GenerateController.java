package com.example.llmgateway.controller;
import com.example.llmgateway.service.LlmService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class GenerateController {

    private final LlmService llmService;

    public GenerateController(LlmService llmService) {
        this.llmService = llmService;
    }

    @PostMapping
    public String generate(@RequestBody String prompt) {
        return llmService.generate(prompt);
    }
}