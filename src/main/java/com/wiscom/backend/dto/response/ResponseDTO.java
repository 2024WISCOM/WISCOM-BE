package com.wiscom.backend.dto.response;

import com.wiscom.backend.dto.sample.SampleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {
    private Integer status;
    private String message;
    private T data;
}
