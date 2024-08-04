package com.wiscom.backend.dto.sample;

import com.wiscom.backend.entity.SampleEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleResponseDTO {
    private Long id;
    private String phoneNum;

    public static SampleResponseDTO toDto(SampleEntity entity) {
        return SampleResponseDTO.builder()
                .id(entity.getId())
                .phoneNum(entity.getPhoneNum())
                .build();
    }
}
