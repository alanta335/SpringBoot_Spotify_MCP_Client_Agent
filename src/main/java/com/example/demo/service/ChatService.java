package com.example.demo.service;

import com.example.demo.model.request.ChatRequestDto;
import com.example.demo.model.response.QueryResultResponseDto;

public interface ChatService {
    QueryResultResponseDto getChatResponse(ChatRequestDto requestDto);
}
