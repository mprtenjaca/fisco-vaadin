package com.mcode.fisco.backend.repository;

import com.mcode.fisco.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserServiceRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
