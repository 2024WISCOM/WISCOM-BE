package com.wiscom.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wiscom.backend.dto.sample.SampleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {
    private Integer status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 생성자 오버로딩: 데이터가 없는 경우 사용
    public ResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }
}
