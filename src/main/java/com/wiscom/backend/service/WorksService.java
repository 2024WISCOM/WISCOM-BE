package com.wiscom.backend.service;

import com.wiscom.backend.dto.response.WorksDetailResponseDTO;
import com.wiscom.backend.dto.response.WorksResponseDTO;
import com.wiscom.backend.entity.WorksEntity;
import com.wiscom.backend.repository.WorksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorksService {
    private final WorksRepository worksRepository;

    public List<WorksResponseDTO> getAllWorks() {
        return worksRepository.findAll().stream()
                .map(WorksResponseDTO::new)
                .collect(Collectors.toList());
    }

    public WorksDetailResponseDTO getWorkDetail(Long id) {
        WorksEntity work = worksRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Work not found"));
        return new WorksDetailResponseDTO(work);
    }

    public List<WorksResponseDTO> getWorksByCategory(String category) {
        return worksRepository.findByCategory(category).stream()
                .map(WorksResponseDTO::new)
                .collect(Collectors.toList());
    }
}
