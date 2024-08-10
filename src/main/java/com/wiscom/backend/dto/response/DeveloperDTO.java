package com.wiscom.backend.dto.response;

import com.wiscom.backend.entity.DeveloperEntity;
import lombok.Getter;

@Getter
class DeveloperDTO {
    private String name;
    private String role;

    public DeveloperDTO(DeveloperEntity developer) {
        this.name = developer.getName();
        this.role = developer.getRole();
    }
}
