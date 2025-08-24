package com.example.mcp_client.model.dto.request.common;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Generic request DTO containing data, user information, and metadata")
public record GenricRequestDto<T>(
        @Schema(description = "Payload data") T data,
        @Schema(description = "User data") UserDataRequsetDto userData,
        @Schema(description = "Metadata") MetaDataRequestDto metaData
) {
}
