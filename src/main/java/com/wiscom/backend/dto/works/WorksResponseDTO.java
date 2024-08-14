package com.wiscom.backend.dto.works;

import com.wiscom.backend.entity.WorksEntity;
import lombok.Getter;

@Getter
public class WorksResponseDTO {
    private final Long id;
    private final String title;
    private final String imageUrl;

    public WorksResponseDTO(WorksEntity work) {
        this.id = work.getId();
        this.title = work.getTitle();
        this.imageUrl = work.getImageUrl();
    }
}
