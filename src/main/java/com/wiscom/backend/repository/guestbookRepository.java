package com.wiscom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wiscom.backend.entity.guestbookEntity;

public interface guestbookRepository extends JpaRepository<guestbookEntity, Long> {
}
