package com.example.demo.controller;

import com.example.demo.exception.LLMServiceException;
import com.example.demo.model.request.ChatRequestDto;
import com.example.demo.model.response.QueryResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatClient chatClient;

    private final List<ToolCallback> toolCallbackProvider;

    @PostMapping("/chat")
    public QueryResultResponseDto chat(@RequestBody ChatRequestDto requestDto) {
        try {
            return new QueryResultResponseDto(chatClient
                    .prompt()
                    .system("""
                            You are a helpful assistant that manages music playlists.
                            Use the provided tools to fetch and control playlists.
                            Respond naturally in conversation format to the user's requests based on the outcomes of tool executions.
                            Do not output any code blocks or markdown or with html tags.
                            If you cannot answer the question, respond with "I don't know".
                            """)
                    .user(requestDto.prompt())
                    .tools(toolCallbackProvider)
                    .call()
                    .content());
        } catch (Exception e) {
            throw new LLMServiceException(e.getMessage());
        }
    }
}
