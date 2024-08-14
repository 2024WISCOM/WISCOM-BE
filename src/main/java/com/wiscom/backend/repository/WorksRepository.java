package com.wiscom.backend.repository;

import com.wiscom.backend.entity.WorksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorksRepository extends JpaRepository<WorksEntity, Long> {
    List<WorksEntity> findByCategory(String category);

    // 이전 항목 찾기
    Optional<WorksEntity> findFirstByIdLessThanOrderByIdDesc(Long id);
    Optional<WorksEntity> findFirstByIdLessThanAndCategoryOrderByIdDesc(Long id, String category);

    // 다음 항목 찾기
    Optional<WorksEntity> findFirstByIdGreaterThanOrderByIdAsc(Long id);
    Optional<WorksEntity> findFirstByIdGreaterThanAndCategoryOrderByIdAsc(Long id, String category);

    // 가장 큰 ID를 가진 항목 찾기
    WorksEntity findTopByOrderByIdDesc();
    WorksEntity findTopByCategoryOrderByIdDesc(String category);

    // 가장 작은 ID를 가진 항목 찾기
    WorksEntity findTopByOrderByIdAsc();
    WorksEntity findTopByCategoryOrderByIdAsc(String category);
}