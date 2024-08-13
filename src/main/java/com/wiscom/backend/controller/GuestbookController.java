package com.wiscom.backend.controller;

import com.wiscom.backend.dto.guestbook.GuestBookResponseDTO;
import com.wiscom.backend.dto.response.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.wiscom.backend.dto.guestbook.GuestBookDTO;
import com.wiscom.backend.service.GuestbookService;

@RestController
@RequestMapping("/api/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO<GuestBookDTO.Res>> createEntry(@RequestBody GuestBookDTO dto) {
        try {
            GuestBookDTO.Res createdEntity = service.saveEntry(dto);
            ResponseDTO<GuestBookDTO.Res> response = new ResponseDTO<>(
                    HttpStatus.CREATED.value(),
                    "방명록을 성공적으로 작성했습니다.",
                    createdEntity
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ResponseDTO<GuestBookDTO.Res> response = new ResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "방명록 작성을 실패했습니다."
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> list(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="9") int size
    ) {
        GuestBookResponseDTO response = service.getEntries(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(HttpStatus.OK.value(), "방명록을 성공적으로 조회했습니다.", response));
    }
}