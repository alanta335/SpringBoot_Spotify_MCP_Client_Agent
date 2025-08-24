package com.example.mcp_client.controller;

import com.example.mcp_client.model.dto.request.ChatRequestDto;
import com.example.mcp_client.model.dto.request.common.GenricRequestDto;
import com.example.mcp_client.model.dto.response.QueryResultResponseDto;
import com.example.mcp_client.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/chat")
    public QueryResultResponseDto chat(@RequestBody GenricRequestDto<ChatRequestDto> requestDto) {
        return chatService.getChatResponse(requestDto);
    }
}
