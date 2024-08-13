package com.wiscom.backend.dto.guestbook;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GuestbookDTO {
    private final String author;
    private final String message;
    private final String recipient;

    @JsonCreator
    public GuestbookDTO(
            @JsonProperty("author") String author,
            @JsonProperty("message") String message,
            @JsonProperty("recipient") String recipient) {
        this.author = author;
        this.message = message;
        this.recipient = recipient;
    }
}
