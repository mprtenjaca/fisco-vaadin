package com.mcode.fisco.backend.services.implementation;

import com.mcode.fisco.backend.dto.CustomerDTO;
import com.mcode.fisco.backend.models.Customer;
import com.mcode.fisco.backend.repository.CustomerServiceRepository;
import com.mcode.fisco.backend.services.CustomerService;
import com.mcode.fisco.backend.services.JdbcCustomerRepository;
import com.mcode.fisco.backend.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService, Utils {

    private final CustomerServiceRepository customerServiceRepository;
    private JdbcCustomerRepository jdbcCustomerRepository;

    public CustomerServiceImpl(CustomerServiceRepository customerServiceRepository, JdbcCustomerRepository jdbcCustomerRepository) {
        this.customerServiceRepository = customerServiceRepository;
        this.jdbcCustomerRepository = jdbcCustomerRepository;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerServiceRepository.findAll().stream().map(customer -> mapCustomerToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomersByUserId(Long id) {
        return customerServiceRepository.findByUserId(id).stream().map(customer -> mapCustomerToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerServiceRepository.findById(id).map(customer -> mapCustomerToDTO(customer));
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return customerServiceRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerServiceRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerServiceRepository.delete(id);
    }


}
