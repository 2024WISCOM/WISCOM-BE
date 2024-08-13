package com.wiscom.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wiscom.backend.dto.guestbook.GuestbookDTO;

import com.wiscom.backend.entity.GuestbookEntity;
import com.wiscom.backend.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository repository;

    public GuestbookEntity saveEntry(GuestbookDTO dto) {
        GuestbookEntity entity = new GuestbookEntity(dto.getAuthor(), dto.getMessage(), dto.getRecipient());
        return repository.save(entity);
    }

    public Page<GuestbookEntity> getEntries(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("createDate")));
        return repository.findAll(pageable);
    }
}
