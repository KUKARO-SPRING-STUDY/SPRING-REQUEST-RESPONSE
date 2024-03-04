package org.example.springrequestresponse.response;

public enum ErrorCode {
    SUCCESS(2000),
    SERVER_ERROR(5000);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
