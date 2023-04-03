package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.dto.CompanyDTO;
import com.mcode.fisco.backend.models.Company;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface CompanyService {
    List<CompanyDTO> getCompanies();
    Optional<CompanyDTO> getCompanyById(Long id);
    Optional<CompanyDTO> getCompanyByUserId(Long id);
    Optional<Company> save(Company company);
    Optional<CompanyDTO> update(Long id, Company company);
    void delete(Long id);

}
