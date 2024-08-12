package com.wiscom.backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.wiscom.backend.dto.guestbook.guestbookDTO;
import com.wiscom.backend.entity.guestbookEntity;
import com.wiscom.backend.repository.guestbookRepository;

@Service
@RequiredArgsConstructor
public class guestbookService {

    private final guestbookRepository repository;

    public guestbookEntity saveEntry(guestbookDTO dto) {
        try {
            guestbookEntity entity = new guestbookEntity(dto.getAuthor(), dto.getMessage(), dto.getRecipient());
            return repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그 기록
            throw new RuntimeException("Error saving guestbook entry: " + e.getMessage());
        }
    }



}