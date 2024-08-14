package com.wiscom.backend.dto.developer;

import com.wiscom.backend.entity.DeveloperEntity;
import lombok.Getter;

@Getter
public class DeveloperDTO {
    private String name;
    private String role;

    public DeveloperDTO(DeveloperEntity developer) {
        this.name = developer.getName();
        this.role = developer.getRole();
    }
}
