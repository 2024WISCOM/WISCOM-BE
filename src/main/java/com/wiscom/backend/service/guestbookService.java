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
        guestbookEntity entity = new guestbookEntity(dto.getAuthor(), dto.getMessage(), dto.getRecipient());
        return repository.save(entity);
    }


}