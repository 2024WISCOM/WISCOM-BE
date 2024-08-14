package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.ResponseDTO;
import com.wiscom.backend.dto.response.WorksDetailResponseDTO;
import com.wiscom.backend.dto.response.WorksResponseDTO;
import com.wiscom.backend.service.WorksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/works")
@RequiredArgsConstructor
public class WorksController {
    private final WorksService workService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<WorksResponseDTO>>> getWorks() {
        List<WorksResponseDTO> works = workService.getAllWorks();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "Works 데이터를 성공적으로 조회했습니다.", works));
    }

    // all에서 상세 조회로 넘어간 경우
    @GetMapping("/all/{id}")
    public ResponseEntity<ResponseDTO<WorksDetailResponseDTO>> getWorkDetail(@PathVariable Long id) {
        WorksDetailResponseDTO workDetail = workService.getWorkDetail(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "Work detail 데이터를 성공적으로 조회했습니다.", workDetail));
    }

    @GetMapping("/category")
    public ResponseEntity<ResponseDTO<List<WorksResponseDTO>>> getWorksByCategory(@RequestParam String category) {
        List<WorksResponseDTO> works = workService.getWorksByCategory(category);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "카테고리별 Works 데이터를 성공적으로 조회했습니다.", works));
    }
}
