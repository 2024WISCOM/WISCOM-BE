package com.wiscom.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //조회 페이지
    private String title;
    private String category;
    private String imageUrl;

    //상세 페이지
    private String shortDescription;
    private String deployUrl;
    private String teamName;
    private String instagramUrl;
    private String githubUrl;
    private String description;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private Set<DeveloperEntity> developers = new HashSet<>();

}
