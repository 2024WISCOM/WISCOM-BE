package com.wiscom.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class GuestbookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String message;
    private String recipient;
    private LocalDateTime createDate; 

    public GuestbookEntity(String author, String message, String recipient) {
        this.author = author;
        this.message = message;
        this.recipient = recipient;
        this.createDate = LocalDateTime.now(); 
    }
}

