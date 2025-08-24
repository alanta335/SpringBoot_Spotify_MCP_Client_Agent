package com.example.demo.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for chat requests")
public record ChatRequestDto(
        @Schema(description = "Prompt for the chat", example = "Hello, how are you?", requiredMode = Schema.RequiredMode.REQUIRED)
        String prompt,
        @Schema(description = "User ID", example = "12345")
        String userId,
        @Schema(description = "User name", example = "john_doe")
        String userName,
        @Schema(description = "API key for authentication", example = "sk-abcdef123456", requiredMode = Schema.RequiredMode.REQUIRED)
        String apiKey
) {
}
