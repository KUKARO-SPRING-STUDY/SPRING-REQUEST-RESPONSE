package org.example.springrequestresponse.response;

public record Status(
        int code,
        String message
) {
    public Status(ErrorCode code, String message) {
        this(code.getCode(), message);
    }
}
