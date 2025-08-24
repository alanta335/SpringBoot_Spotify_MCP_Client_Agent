package com.example.demo.controller;

import com.example.demo.model.request.ChatRequestDto;
import com.example.demo.model.response.QueryResultResponseDto;
import com.example.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/chat")
    public QueryResultResponseDto chat(@RequestBody ChatRequestDto requestDto) {
        return chatService.getChatResponse(requestDto);
    }
}
