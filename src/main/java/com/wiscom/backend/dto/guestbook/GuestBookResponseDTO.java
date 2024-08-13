package com.wiscom.backend.dto.guestbook;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestBookResponseDTO {
    private int totalPages;
    private int currentPage;
    private long totalElements;
    private int pageSize;
    private List<GuestBookDTO.Res> guestBooks;
}
