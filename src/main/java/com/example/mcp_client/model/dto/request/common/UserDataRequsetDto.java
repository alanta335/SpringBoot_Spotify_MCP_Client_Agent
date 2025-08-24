package com.example.mcp_client.model.dto.request.common;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserDataRequsetDto(@Schema(description = "User ID", example = "12345")
                       String userId,
                                 @Schema(description = "User name", example = "john_doe")
                       String userName,
                                 @Schema(description = "API key for authentication", example = "sk-abcdef123456", requiredMode = Schema.RequiredMode.REQUIRED)
                       String apiKey) {
}
