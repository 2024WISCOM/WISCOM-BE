package com.wiscom.backend.service;

import com.wiscom.backend.dto.response.WorksDetailResponseDTO;
import com.wiscom.backend.dto.response.WorksResponseDTO;
import com.wiscom.backend.entity.CategoryEnum;
import com.wiscom.backend.entity.WorksEntity;
import com.wiscom.backend.exception.WorkNotFoundException;
import com.wiscom.backend.exception.InvalidCategoryException;
import com.wiscom.backend.exception.WorkNotInCategoryException;
import com.wiscom.backend.repository.WorksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorksService {
    private final WorksRepository worksRepository;

    public List<WorksResponseDTO> getWorksByCategory(String categoryString) {
        // 전체 조회인지 비교
        if (categoryString.equalsIgnoreCase("ALL")) {
            return worksRepository.findAll().stream()
                    .map(WorksResponseDTO::new)
                    .collect(Collectors.toList());
        }

        // 문자열을 CategoryEnum으로 변환
        CategoryEnum category;
        try {
            category = CategoryEnum.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException(categoryString);
        }

        // 해당 카테고리를 포함하는 WorksEntity를 조회
        return worksRepository.findByCategoriesContaining(category).stream()
                .map(WorksResponseDTO::new)
                .collect(Collectors.toList());
    }

    public WorksDetailResponseDTO getWorkDetail(String categoryString, Long id) {
        // 전체 조회인지 비교
        if (categoryString.equalsIgnoreCase("ALL")) {
            WorksEntity work = worksRepository.findById(id)
                    .orElseThrow(() -> new WorkNotFoundException(id));

            Long prev = worksRepository.findFirstByIdLessThanOrderByIdDesc(id)
                    .map(WorksEntity::getId)
                    .orElseGet(() -> worksRepository.findTopByOrderByIdDesc().getId());

            Long next = worksRepository.findFirstByIdGreaterThanOrderByIdAsc(id)
                    .map(WorksEntity::getId)
                    .orElseGet(() -> worksRepository.findTopByOrderByIdAsc().getId());

            return new WorksDetailResponseDTO(work, prev, next);
        }

        CategoryEnum category;
        try {
            category = CategoryEnum.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException(categoryString);
        }

        WorksEntity work = worksRepository.findById(id)
                .orElseThrow(() -> new WorkNotFoundException(id));

        // 현재 Work에 해당 카테고리가 포함되어 있는지 확인
        if (!work.getCategories().contains(category)) {
            throw new WorkNotInCategoryException(id, categoryString);
        }

        Long prev = worksRepository.findFirstByIdLessThanAndCategoriesContainingOrderByIdDesc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoriesContainingOrderByIdDesc(category).getId());

        Long next = worksRepository.findFirstByIdGreaterThanAndCategoriesContainingOrderByIdAsc(id, category)
                .map(WorksEntity::getId)
                .orElseGet(() -> worksRepository.findTopByCategoriesContainingOrderByIdAsc(category).getId());

        return new WorksDetailResponseDTO(work, prev, next);
    }
}
