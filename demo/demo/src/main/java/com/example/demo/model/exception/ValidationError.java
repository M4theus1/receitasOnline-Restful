package com.example.demo.model.exception;

import lombok.Data;

@Data
public class ValidationError {
    private String field;
    private String error;

    public ValidationError(String field, String error) {
        this.field = field;
        this.error = error;
    }
}