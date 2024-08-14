package com.wiscom.backend.repository;

import com.wiscom.backend.entity.CategoryEnum;
import com.wiscom.backend.entity.WorksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorksRepository extends JpaRepository<WorksEntity, Long> {
    // 이전 항목 찾기
    Optional<WorksEntity> findFirstByIdLessThanAndCategoriesContainingOrderByIdDesc(Long id, CategoryEnum category);

    // 다음 항목 찾기
    Optional<WorksEntity> findFirstByIdGreaterThanAndCategoriesContainingOrderByIdAsc(Long id, CategoryEnum category);

    // 가장 큰 ID를 가진 항목 찾기
    WorksEntity findTopByCategoriesContainingOrderByIdDesc(CategoryEnum category);

    // 가장 작은 ID를 가진 항목 찾기
    WorksEntity findTopByCategoriesContainingOrderByIdAsc(CategoryEnum category);

    // 특정 id보다 작은 id 중에서 가장 큰 id를 가진 항목을 조회 (이전 항목)
    Optional<WorksEntity> findFirstByIdLessThanOrderByIdDesc(Long id);

    // 특정 id보다 큰 id 중에서 가장 작은 id를 가진 항목을 조회 (다음 항목)
    Optional<WorksEntity> findFirstByIdGreaterThanOrderByIdAsc(Long id);

    // 가장 큰 id를 가진 항목을 조회
    WorksEntity findTopByOrderByIdDesc();

    // 가장 작은 id를 가진 항목을 조회
    WorksEntity findTopByOrderByIdAsc();

    List<WorksEntity> findByCategoriesContaining(CategoryEnum category);

}