package com.wiscom.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String category;
    private String imageUrl;

    //상세 페이지
    private String pptImages;
    private String shortDescription;
    private String deployUrl;
    private String teamName;
    private String instagramUrl;
    private String githubUrl;
    private String description;


    public WorksEntity(String title, String category, String imageUrl, String pptImages, String shortDescription,
                       String deployUrl, String teamName, String instagramUrl, String githubUrl, String description) {
        this.title = title;
        this.category = category;
        this.imageUrl = imageUrl;
        this.pptImages = pptImages;
        this.shortDescription = shortDescription;
        this.deployUrl = deployUrl;
        this.teamName = teamName;
        this.instagramUrl = instagramUrl;
        this.githubUrl = githubUrl;
        this.description = description;
    }
}
