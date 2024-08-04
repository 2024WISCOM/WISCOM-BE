package com.wiscom.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @setter 사용 금지
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNum;

    public SampleEntity(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
