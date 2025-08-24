package com.example.mcp_client.model.dto.request.common;

public record GenricRequestDto<T>(T data, UserDataRequsetDto userData, MetaDataRequestDto metaData) {
}
