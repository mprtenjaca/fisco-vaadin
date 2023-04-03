package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.List;

public interface CustomerServiceRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByUserId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = :id")
    void delete(@Param("id") Long id);
}
