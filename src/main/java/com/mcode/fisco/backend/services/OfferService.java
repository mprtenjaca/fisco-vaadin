package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.models.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    List<Offer> getAll();
    List<Offer> getOffersByUserId(Long id);
    Optional<Offer> getOfferById(Long id);
    List<Offer> findByCustomerId(Long id);
    List<Offer> findByServiceModelId(Long id);
    Offer save(Offer offer);
    Optional<Offer> update(Long id, Offer offer);
    void delete(Long id);
}
