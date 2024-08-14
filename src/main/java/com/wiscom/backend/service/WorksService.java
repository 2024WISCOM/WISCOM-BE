package com.wiscom.backend.service;

import com.wiscom.backend.dto.response.WorksDetailResponseDTO;
import com.wiscom.backend.dto.response.WorksResponseDTO;
import com.wiscom.backend.entity.CategoryEnum;
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
    public WorksDetailResponseDTO getCategoryWorkDetail(String categoryString, Long id) {
        CategoryEnum category = CategoryEnum.valueOf(categoryString.toUpperCase());

        WorksEntity work = worksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Work not found"));

        // 현재 Work에 해당 카테고리가 포함되어 있는지 확인
        if (!work.getCategories().contains(category)) {
            throw new IllegalArgumentException("Work does not belong to the specified category");
        }

        Long prev = worksRepository.findFirstByIdLessThanAndCategoriesContainingOrderByIdDesc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoriesContainingOrderByIdDesc(category).getId());

        Long next = worksRepository.findFirstByIdGreaterThanAndCategoriesContainingOrderByIdAsc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoriesContainingOrderByIdAsc(category).getId());

        return new WorksDetailResponseDTO(work, prev, next);
    }

    public List<WorksResponseDTO> getWorksByCategory(String categoryString) {
        // 전체 조회인지 비교
        if(categoryString.equalsIgnoreCase("ALL")) {
            return worksRepository.findAll().stream()
                    .map(WorksResponseDTO::new)
                    .collect(Collectors.toList());
        }

        // 문자열을 CategoryEnum으로 변환
        CategoryEnum category = CategoryEnum.valueOf(categoryString.toUpperCase());

        // 해당 카테고리를 포함하는 WorksEntity를 조회
        return worksRepository.findByCategoriesContaining(category).stream()
                .map(WorksResponseDTO::new)
                .collect(Collectors.toList());
    }
}
