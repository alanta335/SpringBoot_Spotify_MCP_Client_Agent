package com.example.mcp_client.service;

import com.example.mcp_client.model.request.ChatRequestDto;
import com.example.mcp_client.model.response.QueryResultResponseDto;

public interface ChatService {
    QueryResultResponseDto getChatResponse(ChatRequestDto requestDto);
}
