package com.wiscom.backend.repository;

import com.wiscom.backend.entity.GuestbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long> {
	Page<GuestbookEntity> findAllByOrderByIdDesc(Pageable pageable);
}