package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.dto.ServiceModelDTO;
import com.mcode.fisco.backend.models.ServiceModel;

import java.util.List;
import java.util.Optional;

public interface ServiceModelService {
    List<ServiceModelDTO> getAll();
    Optional<ServiceModelDTO> getServiceModelById(Long id);
    List<ServiceModelDTO> getServiceModelsByUserId(Long id);
    Optional<ServiceModel> getById(Long id);
    Optional<ServiceModelDTO> update(Long id, ServiceModel serviceModel);
    ServiceModel save(ServiceModel serviceModel);
    void delete(Long id);
}
