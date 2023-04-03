package com.mcode.fisco.backend.utils;

import com.mcode.fisco.backend.dto.CustomerDTO;
import com.mcode.fisco.backend.models.Customer;

public interface Utils {
    default CustomerDTO mapCustomerToDTO(final Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCompanyName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getOib(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhoneNumber(),
                customer.getFax(),
                customer.getCreatedAt()
        );
    }
}
