package com.wiscom.backend.dto.response;

import com.wiscom.backend.entity.ImageEntity;
import lombok.Getter;

@Getter
public class ImageResponseDTO {
    private String url;

    public ImageResponseDTO(ImageEntity image) {
        this.url = image.getUrl();
    }

}
