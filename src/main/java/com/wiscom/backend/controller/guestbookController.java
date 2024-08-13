package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.ResponseDTO;
import com.wiscom.backend.service.GuestbookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.wiscom.backend.dto.guestbook.guestbookDTO;
import com.wiscom.backend.entity.GuestbookEntity;

@RestController
@RequestMapping("/api/guestbook")
@RequiredArgsConstructor
public class guestbookController {

    private final GuestbookService service;

    @PostMapping("/entities")
    public ResponseEntity<ResponseDTO<GuestbookEntity>> createEntry(@RequestBody guestbookDTO dto) {
        try {
            GuestbookEntity createdEntity = service.saveEntry(dto);
            ResponseDTO<GuestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.CREATED.value(),
                    "방명록을 성공적으로 생성했습니다.",
                    createdEntity
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ResponseDTO<GuestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "방명록 생성을 실패했습니다."
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
