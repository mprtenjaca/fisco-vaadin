package com.mcode.fisco.backend.services;


import com.mcode.fisco.backend.dto.CustomerDTO;
import com.mcode.fisco.backend.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAll();
    List<CustomerDTO> getCustomersByUserId(Long id);
    Optional<CustomerDTO> getCustomerById(Long id);
    Optional<Customer> getById(Long id);
    Customer save(Customer customer);
    void delete(Long id);
}
