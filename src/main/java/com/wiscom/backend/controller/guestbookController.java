package com.wiscom.backend.controller;

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
    public ResponseEntity<guestbookEntity> createEntry(@RequestBody guestbookDTO dto) {
        guestbookEntity createdEntry = service.saveEntry(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntry);
    }
}
