package com.example.mcp_client.service;

import com.example.mcp_client.model.dto.request.ChatRequestDto;
import com.example.mcp_client.model.dto.request.common.GenricRequestDto;
import com.example.mcp_client.model.dto.response.QueryResultResponseDto;

public interface ChatService {
    QueryResultResponseDto getChatResponse(GenricRequestDto<ChatRequestDto> requestDto);
}
