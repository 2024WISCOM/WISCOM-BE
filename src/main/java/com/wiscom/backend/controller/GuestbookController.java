package com.wiscom.backend.controller;

import com.wiscom.backend.dto.response.PaginationResponseDTO;
import com.wiscom.backend.dto.response.ResponseDTO;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.wiscom.backend.dto.guestbook.GuestbookDTO;
import com.wiscom.backend.entity.GuestbookEntity;
import com.wiscom.backend.service.GuestbookService;

@RestController
@RequestMapping("/api/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO<GuestbookEntity>> createEntry(@RequestBody GuestbookDTO dto) {
        try {
            GuestbookEntity createdEntity = service.saveEntry(dto);
            ResponseDTO<GuestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.CREATED.value(),
                    "성공했습니다",
                    createdEntity
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ResponseDTO<GuestbookEntity> response = new ResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "실패했습니다"
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    @GetMapping
    public ResponseEntity<PaginationResponseDTO<GuestbookEntity>> list(
        @RequestParam(value="page", defaultValue="0") int page,
        @RequestParam(value="size", defaultValue="9") int size
    ) {
        Page<GuestbookEntity> paging = service.getEntries(page, size);

        PaginationResponseDTO<GuestbookEntity> response = new PaginationResponseDTO<>(
            HttpStatus.OK.value(),
            "데이터 조회 성공",
            paging.getContent(),
            paging.getTotalPages(),
            paging.getNumber(),        // 현재 페이지 번호
            paging.getTotalElements(), // 총 아이템 수
            paging.getSize()           // 페이지 크기 
        );

        return ResponseEntity.ok(response);
    }
}
