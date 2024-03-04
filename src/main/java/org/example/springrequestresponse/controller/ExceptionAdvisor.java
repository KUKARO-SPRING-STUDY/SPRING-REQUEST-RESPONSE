package org.example.springrequestresponse.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.springrequestresponse.exception.CustomException;
import org.example.springrequestresponse.response.ApiResponse;
import org.example.springrequestresponse.response.InputRestriction;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvisor {
    /**
     * instanceOf후 패턴매칭은 자버버전 16부터 지원합니다.
     * 그 이전 버전은 instanceof로 타입을 체크하고, 각 타입에 맞게 캐스팅을 해주어야 합니다.
     */
    @ExceptionHandler(CustomException.class)
    public ApiResponse<InputRestriction> handleCustomException(HttpServletResponse response, CustomException e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ApiResponse<>(e.getErrorCode(), e.getMessage(), e.getData());
    }
}
