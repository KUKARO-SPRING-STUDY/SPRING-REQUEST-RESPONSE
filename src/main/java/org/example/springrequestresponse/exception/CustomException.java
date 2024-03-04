package org.example.springrequestresponse.exception;

import lombok.Getter;
import org.example.springrequestresponse.response.ErrorCode;
import org.example.springrequestresponse.response.InputRestriction;


@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final InputRestriction data;

    public CustomException(ErrorCode errorCode, String message, InputRestriction data) {
        super(message);
        this.errorCode = errorCode;
        this.data = data;
    }
}
