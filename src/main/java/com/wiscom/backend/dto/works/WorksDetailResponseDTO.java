package com.wiscom.backend.dto.works;

import com.wiscom.backend.dto.developer.DeveloperDTO;
import com.wiscom.backend.dto.response.ImageResponseDTO;
import com.wiscom.backend.entity.WorksEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class WorksDetailResponseDTO {
    private final Long id;
    private final String title;
    private final String shortDescription;
    private final String deployUrl;
    private final String teamName;
    private final String instagramUrl;
    private final String githubUrl;
    private final String description;
    private final List<DeveloperDTO> developers;
    private final List<ImageResponseDTO> images;
    private final Long prev;
    private final Long next;

    public WorksDetailResponseDTO(WorksEntity work, Long prev, Long next) {
        this.id = work.getId();
        this.title = work.getTitle();
        this.shortDescription = work.getShortDescription();
        this.deployUrl = work.getDeployUrl();
        this.teamName = work.getTeamName();
        this.instagramUrl = work.getInstagramUrl();
        this.githubUrl = work.getGithubUrl();
        this.description = work.getDescription();

        this.developers = work.getDevelopers().stream()
                .map(DeveloperDTO::new)
                .collect(Collectors.toList());

        this.images = work.getImages().stream()
                .map(ImageResponseDTO::new)
                .collect(Collectors.toList());

        this.prev = prev;
        this.next = next;
    }
}
