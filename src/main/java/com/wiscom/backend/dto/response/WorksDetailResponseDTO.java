package com.wiscom.backend.dto.response;

import com.wiscom.backend.entity.WorksEntity;
import lombok.Getter;

@Getter
public class WorksDetailResponseDTO {
    private Long id;
    private String title;
    private String pptImages;
    private String shortDescription;
    private String deployUrl;
    private String teamName;
    private String instagramUrl;
    private String githubUrl;
    private String description;

    public WorksDetailResponseDTO(WorksEntity work) {
        this.id = work.getId();
        this.title = work.getTitle();

        this.pptImages = work.getPptImages();
        this.shortDescription = work.getShortDescription();
        this.deployUrl = work.getDeployUrl();
        this.teamName = work.getTeamName();
        this.instagramUrl = work.getInstagramUrl();
        this.githubUrl = work.getGithubUrl();
        this.description = work.getDescription();
    }
}
