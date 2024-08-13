package com.wiscom.backend.service;

import com.wiscom.backend.dto.guestbook.GuestbookResponseDTO;
import com.wiscom.backend.dto.guestbook.GuestbookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wiscom.backend.entity.GuestbookEntity;
import com.wiscom.backend.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository repository;

    public GuestbookDTO.Res saveEntry(GuestbookDTO dto) {
        GuestbookEntity entity = new GuestbookEntity(dto.getAuthor(), dto.getMessage(), dto.getRecipient());
        GuestbookEntity guestbook = repository.save(entity);
        return GuestbookDTO.Res.toDto(guestbook);
    }

    @Transactional(readOnly = true)
    public GuestbookResponseDTO getEntries(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GuestbookEntity> guestbookPage = repository.findAllByOrderByIdDesc(pageable);
        List<GuestbookEntity> notices = guestbookPage.getContent();

        List<GuestbookDTO.Res> guestBookDTOS = notices.stream()
                .map(GuestbookDTO.Res::toDto)
                .toList();

        return GuestbookResponseDTO.builder()
                .totalPages(guestbookPage.getTotalPages())
                .currentPage(guestbookPage.getNumber())
                .totalElements(guestbookPage.getTotalElements())
                .pageSize(guestbookPage.getSize())
                .guestBooks(guestBookDTOS)
                .build();
    }
}
