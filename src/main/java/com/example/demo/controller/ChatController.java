package com.example.demo.controller;

import com.example.demo.model.request.ChatRequestDto;
import com.example.demo.model.response.QueryResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatClient chatClient;

    private final List<ToolCallback> toolCallbackProvider;

    @GetMapping("/chat")
    public QueryResultResponseDto chat(@RequestBody ChatRequestDto requestDto) {
        try {
            return chatClient
                    .prompt()
                    .system("""
                            The database contains schema called mydb.
                            Use the schema data provided.
                            
                            CREATE TABLE mydb.users (
                            	id int4 NOT NULL,
                            	"name" varchar(100) NULL,
                            	email varchar(100) NULL,
                            	address varchar(255) NULL,
                            	created timestamp NULL,
                            	last_updated timestamp NULL,
                            	CONSTRAINT users_email_key UNIQUE (email),
                            	CONSTRAINT users_pkey PRIMARY KEY (id)
                            );
                            
                            This is the schema of the users table which contains the data for users.
                            """)
                    .user(requestDto.prompt())
                    .tools(toolCallbackProvider)
                    .call()
                    .entity(QueryResultResponseDto.class);
        } catch (Exception e) {
            return new QueryResultResponseDto("Error = " + e.getMessage());
        }
    }
}
