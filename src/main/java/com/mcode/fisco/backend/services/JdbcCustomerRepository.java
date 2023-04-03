package com.mcode.fisco.backend.services;


import com.mcode.fisco.backend.dto.CustomerDTO;
import com.mcode.fisco.backend.models.Customer;

import java.util.Optional;

public interface JdbcCustomerRepository {
    Optional<CustomerDTO> update(Long id, Customer customer);
}
