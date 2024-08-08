package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.wiscom.backend.dto.guestbook.guestbookDTO;
import com.wiscom.backend.entity.guestbookEntity;
import com.wiscom.backend.service.guestbookService;

@RestController
@RequestMapping("/api/guestbook")
@RequiredArgsConstructor
public class guestbookController {

    private final guestbookService service;

    @PostMapping("/entities")
    public ResponseEntity<ResponseDTO<guestbookEntity>> createEntry(@RequestBody guestbookDTO dto) {
        try {
            guestbookEntity createdEntity = service.saveEntry(dto);
            ResponseDTO<guestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.CREATED.value(),
                    "성공했습니다",
                    createdEntity
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ResponseDTO<guestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "실패했습니다"
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
