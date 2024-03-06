package org.example.springrequestresponse.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record ApiResponse<T>(
        Status status,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Metadata metadata,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<T> results,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    public ApiResponse(ErrorCode errorCode, String message, T data) {
        this(new Status(errorCode, message),
                null,
                null,
                data);
    }

    public static <T> ApiResponse<T> makeResponse(T result) {
        return new ApiResponse<>(new Status(ErrorCode.SUCCESS, "OK"),
                new Metadata(1),
                List.of(result),
                null);
    }

    public static <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(new Status(ErrorCode.SUCCESS, "OK"),
                new Metadata(result.size()),
                result,
                null);
    }
}
