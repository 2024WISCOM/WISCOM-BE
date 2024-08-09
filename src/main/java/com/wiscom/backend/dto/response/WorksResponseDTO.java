package com.wiscom.backend.dto.response;

import com.wiscom.backend.entity.WorksEntity;
import lombok.Getter;

@Getter
public class WorksResponseDTO {
    private Long id;
    private String title;
    private String category;
    private String imageUrl;

    public WorksResponseDTO(WorksEntity work) {
        this.id = work.getId();
        this.title = work.getTitle();
        this.category = work.getCategory();
        this.imageUrl = work.getImageUrl();
    }
}
