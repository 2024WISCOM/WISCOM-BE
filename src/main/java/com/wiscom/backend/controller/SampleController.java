package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.ResponseDTO;
import com.wiscom.backend.dto.sample.SampleResponseDTO;
import com.wiscom.backend.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getSamples() {
        List<SampleResponseDTO> response = sampleService.getSamples();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(HttpStatus.OK.value(), "샘플 데이터를 성공적으로 조회했습니다.", response));
    }
}
