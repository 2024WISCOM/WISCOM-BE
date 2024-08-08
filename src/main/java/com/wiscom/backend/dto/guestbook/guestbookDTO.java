package com.wiscom.backend.dto.guestbook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class guestbookDTO {
    private final String author; // 작성자 (from)
    private final String message; // 메세지
    private final String recipient; // 받는 사람 (to)
}
