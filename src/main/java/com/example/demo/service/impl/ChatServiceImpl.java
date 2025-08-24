package com.example.demo.service.impl;

import com.example.demo.exception.LLMServiceException;
import com.example.demo.model.context.UserDataModel;
import com.example.demo.model.context.UserThreadLocalHolder;
import com.example.demo.model.request.ChatRequestDto;
import com.example.demo.model.response.QueryResultResponseDto;
import com.example.demo.service.ChatService;
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
    private final SyncMcpToolCallbackProvider toolCallbackProvider;

    public QueryResultResponseDto getChatResponse(ChatRequestDto requestDto) {
        try {
            final UserDataModel userData = new UserDataModel(requestDto.userName(), requestDto.userId(), requestDto.apiKey());
            UserThreadLocalHolder.setUserHeader(userData);
            return new QueryResultResponseDto(chatClient
                    .prompt()
                    .system("""
                            You are a helpful assistant that manages music playlists.
                            Use the provided tools get information about song and control song player.
                            Respond naturally in conversation format to the user's requests.
                            Output in json format.
                            """)
                    .user(requestDto.prompt())
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
