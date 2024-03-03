package org.example.springrequestresponse.response;

import java.util.List;

public record ApiResponse<T>(
        Status status,
        Metadata metadata,
        List<T> result
) {
    public static<T> ApiResponse<T> makeResponse(T result) {
        return new ApiResponse<>(new Status(ErrorCode.SUCCESS, "OK"), new Metadata(1), List.of(result));
    }
    public static<T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(new Status(ErrorCode.SUCCESS, "OK"), new Metadata(result.size()), result);
    }
}
