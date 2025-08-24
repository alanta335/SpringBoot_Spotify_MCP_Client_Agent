package com.example.mcp_client.config;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MCPConfig {
    @Bean
    public SyncMcpToolCallbackProvider toolCallbackProvider(List<McpSyncClient> clients) {
        return new SyncMcpToolCallbackProvider(clients);
    }
}
