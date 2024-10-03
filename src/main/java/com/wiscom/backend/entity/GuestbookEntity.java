package com.wiscom.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
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
    @Column(columnDefinition = "TEXT")
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

