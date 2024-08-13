package com.wiscom.backend.repository;

import com.wiscom.backend.entity.guestbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface guestbookRepository extends JpaRepository<guestbookEntity, Long> {
	Page<guestbookEntity> findAll(Pageable pageable);
}