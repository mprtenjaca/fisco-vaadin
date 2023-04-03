package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.models.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ServiceDetailRepository extends JpaRepository<ServiceDetails, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ServiceDetails s WHERE s.id = :id")
    void delete(@Param("id") Long id);
}
