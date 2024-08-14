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

    // all에서 상세 조회로 넘어간 경우
    public WorksDetailResponseDTO getWorkDetail(Long id) {
        WorksEntity work = worksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Work not found"));

        Long prev = worksRepository.findFirstByIdLessThanOrderByIdDesc(id)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByOrderByIdDesc().getId());

        Long next = worksRepository.findFirstByIdGreaterThanOrderByIdAsc(id)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByOrderByIdAsc().getId());

        return new WorksDetailResponseDTO(work, prev, next);
    }

    // 카테고리로 필터링 한 상태에서 상세 조회로 넘어간 경우
    public WorksDetailResponseDTO getCategoryWorkDetail(Long id) {
        WorksEntity work = worksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Work not found"));

        String category = work.getCategory();

        Long prev = worksRepository.findFirstByIdLessThanAndCategoryOrderByIdDesc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoryOrderByIdDesc(category).getId());

        Long next = worksRepository.findFirstByIdGreaterThanAndCategoryOrderByIdAsc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoryOrderByIdAsc(category).getId());

        return new WorksDetailResponseDTO(work, prev, next);
    }

    public List<WorksResponseDTO> getWorksByCategory(String category) {
        return worksRepository.findByCategory(category).stream()
                .map(WorksResponseDTO::new)
                .collect(Collectors.toList());
    }
}
