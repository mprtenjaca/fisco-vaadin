package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.dto.CustomerDTO;
import com.mcode.fisco.backend.models.Customer;
import com.mcode.fisco.backend.services.JdbcCustomerRepository;
import com.mcode.fisco.backend.utils.Utils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcCustomerRepositoryImpl implements JdbcCustomerRepository, Utils {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert customerInsert;

    public JdbcCustomerRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.customerInsert = new SimpleJdbcInsert(jdbc).withTableName("Customer").usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<CustomerDTO> update(Long id, Customer customer) {
        String updateQuery = "UPDATE customer set " +
                "first_name = ?, " +
                "last_name = ?, " +
                "company_name = ?, " +
                "email= ?, " +
                "oib = ?, " +
                "address = ?, " +
                "city = ?, " +
                "postal_code = ?," +
                "country = ?, " +
                "phone_number = ?, " +
                "fax = ?  " +
                "where id = ?";

        jdbc.update(updateQuery,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCompanyName(),
                customer.getEmail(),
                customer.getOib(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhoneNumber(),
                customer.getFax(),
                id);

        return Optional.ofNullable(customer).map(customer1 -> mapCustomerToDTO(customer));
    }
}
