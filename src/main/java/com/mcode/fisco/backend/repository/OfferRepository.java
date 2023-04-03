package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findOfferById(Long id);
    List<Offer> findByCustomerId(Long id);
    List<Offer> findByServiceModelId(Long id);
    List<Offer> findByUserId(Long id);

    @Modifying
    @Query("DELETE FROM Offer o WHERE o.id = :id")
    void delete(@Param("id") Long id);
}
