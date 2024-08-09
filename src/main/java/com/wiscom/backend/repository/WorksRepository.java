package com.wiscom.backend.repository;

import com.wiscom.backend.entity.WorksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorksRepository extends JpaRepository<WorksEntity, Long> {
    List<WorksEntity> findByCategory(String category);
}