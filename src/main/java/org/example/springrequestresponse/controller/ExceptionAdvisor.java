package org.example.springrequestresponse.controller;

import org.example.springrequestresponse.exception.CustomException;
import org.example.springrequestresponse.response.ApiResponse;
import org.example.springrequestresponse.response.InputRestriction;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvisor {
    @ExceptionHandler(CustomException.class)
    public ApiResponse<InputRestriction> handleCustomException(CustomException e) {
        return new ApiResponse<>(e.getErrorCode(), e.getMessage(), e.getData());
    }
}
