package com.mcode.fisco.backend.services;

import com.mcode.fisco.backend.dto.UserDTO;
import com.mcode.fisco.backend.models.User;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserService {

    List<User> getAll();
    Optional<User> getUserById(Long id);
    User findByEmail(String email);
    User saveUser(User user);
    Optional<UserDTO> update(Long id, User user);
    String signUpUser(User user);
    void enableUser(String email);
}
