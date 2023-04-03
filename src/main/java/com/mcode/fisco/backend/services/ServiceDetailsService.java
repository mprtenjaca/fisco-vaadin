package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.models.ServiceDetails;

import java.util.List;
import java.util.Optional;

public interface ServiceDetailsService {
    List<ServiceDetails> getAll();
    Optional<ServiceDetails> getById(Long id);
    ServiceDetails save(ServiceDetails serviceDetails);
    Optional<ServiceDetails> update(Long id, ServiceDetails serviceDetails);
    void delete(Long id);
}
