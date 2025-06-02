package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record QueryResultResponseDto(
        @JsonPropertyDescription("Natural language reply to the user's request, summarizing the outcome of tool executions.")
        String response
) {
}
