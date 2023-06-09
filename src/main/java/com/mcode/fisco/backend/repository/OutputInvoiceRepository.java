package com.mcode.fisco.backend.repository;


import com.mcode.fisco.backend.models.OutputInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Long> {
    Optional<OutputInvoice> findOutputInvoiceById(Long id);
    List<OutputInvoice> findByCustomerId(Long id);
    List<OutputInvoice> findByServiceModelId(Long id);
    List<OutputInvoice> findByUserId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM OutputInvoice o WHERE o.id = :id")
    void delete(@Param("id") Long id);
}
