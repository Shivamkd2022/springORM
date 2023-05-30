package com.shivam.todo.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // For handling the null pointer exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException nex)
    {
        logger.info(nex.getMessage());
        return new ResponseEntity<>("ERROR OCCURED:: "+nex.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    // handling resource not found exception.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        logger.error("Error:::{}",ex.getMessage());
        ExceptionResponse response= new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        response.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

}
