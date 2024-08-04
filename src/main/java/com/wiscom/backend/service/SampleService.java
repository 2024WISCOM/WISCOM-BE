package com.wiscom.backend.service;

import com.wiscom.backend.dto.sample.SampleResponseDTO;
import com.wiscom.backend.entity.SampleEntity;
import com.wiscom.backend.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public List<SampleResponseDTO> getSamples() {
        SampleEntity e1 = new SampleEntity("01012345678");
        SampleEntity e2 = new SampleEntity("01087654321");

        sampleRepository.save(e1);
        sampleRepository.save(e2);

        List<SampleEntity> entities = Arrays.asList(e1, e2);

        return entities.stream()
                .map(SampleResponseDTO::toDto)
                .collect(Collectors.toList());
    }
}
