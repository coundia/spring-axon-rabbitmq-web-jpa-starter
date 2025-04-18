package com.groupe2cs.bizyhub.shared.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponseDto implements Serializable {
    private int code;
    private String message;
    private Object data;

    public static ApiResponseDto ok(Object data) {
        return ApiResponseDto.builder()
                .code(1)
                .message("Success")
                .data(data)
                .build();
    }

    public static ApiResponseDto error(String message) {
        return ApiResponseDto.builder()
                .code(0)
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public String toString() {
        return message;
    }
}