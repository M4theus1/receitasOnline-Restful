package com.example.demo.model.exception;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private List<ValidationError> errors; // Para erros de validação

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}