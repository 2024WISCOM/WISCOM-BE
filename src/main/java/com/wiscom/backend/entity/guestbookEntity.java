package com.wiscom.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class guestbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String message;
    private String recipient;

    public guestbookEntity(String author, String message, String recipient) {
        this.author = author;
        this.message = message;
        this.recipient = recipient;
    }
}
