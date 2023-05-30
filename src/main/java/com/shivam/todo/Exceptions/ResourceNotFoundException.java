package com.shivam.todo.Exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception
{
    private String message;
    private HttpStatus status;

    public ResourceNotFoundException()
    {}

    public ResourceNotFoundException(String message, HttpStatus status) {
        super();
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
