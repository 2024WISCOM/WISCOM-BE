package com.wiscom.backend.dto.response;

import com.wiscom.backend.entity.DeveloperEntity;
import lombok.Getter;

@Getter
public class DeveloperNameDTO {
    private String name;

    public DeveloperNameDTO(DeveloperEntity developer) {
        this.name = developer.getName();
    }
}
