package com.thinkfree.demowebsocket.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final String code;
    private final String message;
    private final T data;
    private final LocalDateTime timestamp;

    public static <T> ApiResponse<T> of(ResponseCode responseCode, T data) {
        return new ApiResponse<>(responseCode.getCode(), responseCode.getMessage(), data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> of(ResponseCode responseCode) {
        return new ApiResponse<>(responseCode.getCode(), responseCode.getMessage(), null, LocalDateTime.now());
    }

}
