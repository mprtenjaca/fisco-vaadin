package com.mcode.fisco.backend.services.implementation;

import com.mcode.fisco.backend.dto.UserDTO;
import com.mcode.fisco.backend.models.User;
import com.mcode.fisco.backend.repository.UserRepository;
import com.mcode.fisco.backend.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final ConfirmationTokenService confirmationTokenService;

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert userInsert;

    public UserServiceImpl(UserRepository userRepository,
//                           PasswordEncoder passwordEncoder,
//                           ConfirmationTokenService confirmationTokenService,
                           JdbcTemplate jdbc) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.confirmationTokenService = confirmationTokenService;
        this.jdbc = jdbc;
        this.userInsert = new SimpleJdbcInsert(jdbc).withTableName("User").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserDTO> update(Long id, User user) {

        String updateQuery = "UPDATE users SET " +
                "first_name = ?, " +
                "last_name = ?, " +
                "oib = ?, " +
                "email = ?, " +
                "phone_number = ? " +
                "WHERE id = ?";

        jdbc.update(updateQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getOib(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getId());

        return Optional.ofNullable(user).map(this::mapUserToDTO);
    }

    @Override
    public String signUpUser(User user) {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email);
//
//        if(user == null){
//            log.error("User not found in the database");
//            throw new UsernameNotFoundException("User not found in the database");
//        }else{
//            log.info("User found in the database with email: {}", email);
//        }
//
//        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
//    }

//    @Override
//    public String signUpUser(User user) {
//        User userByEmail = userRepository.findUserByEmail(user.getEmail());
//
//        if(userByEmail != null){
//            throw new IllegalStateException("Email already taken");
//        }
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        userRepository.save(user);
//
//        String token = UUID.randomUUID().toString();
//        ConfirmationToken confirmationToken = new ConfirmationToken(
//                token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(15),
//                user
//        );
//        confirmationTokenService.saveConfirmationToken(confirmationToken);
//
//        return token;
//    }

    @Override
    public void enableUser(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new IllegalStateException("User not found!");
        }

        user.setEnabled(true);
        userRepository.save(user);
    }

    private UserDTO mapUserToDTO(final User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getOib(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
