package com.wiscom.backend.dto.guestbook;

import com.wiscom.backend.entity.GuestbookEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookDTO {
    private String author;
    private String message;
    private String recipient;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Res {
        private Long id;
        private String author;
        private String message;
        private String recipient;

        public static GuestbookDTO.Res toDto(GuestbookEntity entity) {
            return Res.builder()
                    .id(entity.getId())
                    .author(entity.getAuthor())
                    .message(entity.getMessage())
                    .recipient(entity.getRecipient())
                    .build();
        }
    }
}
