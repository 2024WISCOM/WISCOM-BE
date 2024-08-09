package com.wiscom.backend.repository;

import com.wiscom.backend.entity.WorksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorksRepository extends JpaRepository<WorksEntity, Long> {
}