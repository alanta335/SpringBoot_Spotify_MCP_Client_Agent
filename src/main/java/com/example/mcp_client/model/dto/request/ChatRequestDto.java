package com.example.mcp_client.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for chat requests")
public record ChatRequestDto(
        @Schema(description = "Prompt for the chat", example = "Hello, how are you?", requiredMode = Schema.RequiredMode.REQUIRED)
        String prompt
) {
}
