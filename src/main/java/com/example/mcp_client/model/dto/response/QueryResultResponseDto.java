package com.example.mcp_client.model.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record QueryResultResponseDto(
        @JsonPropertyDescription("Reply to the user's request")
        String response
) {
}
