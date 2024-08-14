package com.wiscom.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private String imageUrl;

    //상세 페이지
    private String shortDescription;
    private String deployUrl;
    private String teamName;
    private String instagramUrl;
    private String githubUrl;
    private String description;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<DeveloperEntity> developers = new ArrayList<>();

    @OneToMany(mappedBy = "work")
    private List<ImageEntity> images = new ArrayList<>();

    @ElementCollection(targetClass = CategoryEnum.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "works_category", joinColumns = @JoinColumn(name = "work_id"))
    @Column(name = "category")
    private List<CategoryEnum> categories = new ArrayList<>();
}
