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

    @GetMapping("/category")
    public ResponseEntity<ResponseDTO<List<WorksResponseDTO>>> getWorksByCategory(@RequestParam String type) {
        List<WorksResponseDTO> works = workService.getWorksByCategory(type);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "카테고리별 Works 데이터를 성공적으로 조회했습니다.", works));
    }

    @GetMapping("/category/{category}/{id}")
    public ResponseEntity<ResponseDTO<WorksDetailResponseDTO>> getCategoryWorkDetail(@PathVariable("category") String category, @PathVariable("id") Long id) {
        WorksDetailResponseDTO workDetail = workService.getWorkDetail(category, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "Work detail 데이터를 성공적으로 조회했습니다.", workDetail));
    }
}
