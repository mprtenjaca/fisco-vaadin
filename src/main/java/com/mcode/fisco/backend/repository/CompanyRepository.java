package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUserId(Long id);

    @Modifying
    @Query("DELETE FROM Company c WHERE c.id = :id")
    void delete(@Param("id") Long id);
}
