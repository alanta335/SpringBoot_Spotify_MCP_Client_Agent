package com.example.demo.exception;

public class LLMServiceException extends RuntimeException {
    public LLMServiceException(String message) {
        super(message);
    }
}
