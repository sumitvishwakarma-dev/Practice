package com.sumitdev.student.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionDto{
    private LocalDateTime time;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,String> validationError;

    public ValidationExceptionDto(LocalDateTime time,
                                  int statusCode,
                                  String error,
                                  String message,
                                  String path,
                                  Map<String, String> validationError) {
        this.time = time;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.validationError = validationError;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getValidationError() {
        return validationError;
    }

    public void setValidationError(Map<String, String> validationError) {
        this.validationError = validationError;
    }
}
