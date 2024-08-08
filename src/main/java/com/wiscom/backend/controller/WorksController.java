package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.ResponseDTO;
import com.wiscom.backend.dto.response.WorksDetailResponseDTO;
import com.wiscom.backend.dto.response.WorksResponseDTO;
import com.wiscom.backend.service.WorksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorksController {
    private final WorksService workService;

    @GetMapping("/works")
    public ResponseEntity<ResponseDTO<List<WorksResponseDTO>>> getWorks() {
        List<WorksResponseDTO> works = workService.getAllWorks();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "Works 데이터를 성공적으로 조회했습니다.", works));
    }

    @GetMapping("/works/{id}")
    public ResponseEntity<ResponseDTO<WorksDetailResponseDTO>> getWorkDetail(@PathVariable Long id) {
        WorksDetailResponseDTO workDetail = workService.getWorkDetail(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "Work detail 데이터를 성공적으로 조회했습니다.", workDetail));
    }
}
