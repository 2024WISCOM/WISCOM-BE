package com.wiscom.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.wiscom.backend.dto.guestbook.guestbookDTO;
import com.wiscom.backend.entity.guestbookEntity;
import com.wiscom.backend.repository.guestbookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class guestbookService {

    private final guestbookRepository repository;

    public guestbookEntity saveEntry(guestbookDTO dto) {
        guestbookEntity entity = new guestbookEntity(dto.getAuthor(), dto.getMessage(), dto.getRecipient());
        return repository.save(entity);
    }

    public Page<guestbookEntity> getEntries(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Order.desc("createDate")));
        return repository.findAll(pageable);
    }
}
