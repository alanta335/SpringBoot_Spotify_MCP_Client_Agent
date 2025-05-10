package com.example.demo.config;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MCPConfig {
    @Bean
    public List<ToolCallback> toolCallbackProvider(List<McpSyncClient> clients) {
        return SyncMcpToolCallbackProvider.syncToolCallbacks(clients);
    }
}
