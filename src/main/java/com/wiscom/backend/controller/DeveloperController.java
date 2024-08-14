package com.wiscom.backend.controller;

import com.wiscom.backend.dto.developer.DeveloperNameDTO;
import com.wiscom.backend.dto.response.ResponseDTO;
import com.wiscom.backend.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<DeveloperNameDTO>>> getAllDevelopers() {
        List<DeveloperNameDTO> developers = developerService.getAllDevelopers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO<>(HttpStatus.OK.value(), "개발자 데이터를 성공적으로 조회했습니다.", developers));
    }
}
