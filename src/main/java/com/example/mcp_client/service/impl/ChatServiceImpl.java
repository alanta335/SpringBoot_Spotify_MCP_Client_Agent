package com.example.mcp_client.service.impl;

import com.example.mcp_client.constant.SystemPrompt;
import com.example.mcp_client.exception.LLMServiceException;
import com.example.mcp_client.model.context.UserDataModel;
import com.example.mcp_client.model.context.UserThreadLocalHolder;
import com.example.mcp_client.model.dto.request.ChatRequestDto;
import com.example.mcp_client.model.dto.request.common.GenricRequestDto;
import com.example.mcp_client.model.dto.response.QueryResultResponseDto;
import com.example.mcp_client.service.AuthService;
import com.example.mcp_client.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatClient chatClient;
    private final AuthService authService;
    private final SyncMcpToolCallbackProvider toolCallbackProvider;

    public QueryResultResponseDto getChatResponse(GenricRequestDto<ChatRequestDto> requestDto) {
        try {
            final String APIKey = authService.getAuthToken();
            final UserDataModel userData = new UserDataModel(requestDto.userData().userName(), requestDto.userData().userId(), APIKey);
            UserThreadLocalHolder.setUserHeader(userData);
            return new QueryResultResponseDto(chatClient
                    .prompt()
                    .system(SystemPrompt.SPOTIFY_CHAT_SYSTEM_PROMPT)
                    .user(requestDto.data().prompt())
                    .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                    .call()
                    .content());
        } catch (Exception e) {
            throw new LLMServiceException(e.getMessage());
        } finally {
            UserThreadLocalHolder.clear();
        }
    }
}
