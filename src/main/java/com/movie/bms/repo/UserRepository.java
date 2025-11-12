package com.movie.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.bms.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);
}
