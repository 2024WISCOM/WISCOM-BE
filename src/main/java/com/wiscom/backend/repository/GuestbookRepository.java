package com.wiscom.backend.repository;

import com.wiscom.backend.entity.GuestbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long> {
	Page<GuestbookEntity> findAllByOrderByIdDesc(Pageable pageable);
	@Query("SELECT g FROM GuestbookEntity g WHERE g.author LIKE %:keyword% OR g.message LIKE %:keyword% OR g.recipient LIKE %:keyword%")
    Page<GuestbookEntity> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}





