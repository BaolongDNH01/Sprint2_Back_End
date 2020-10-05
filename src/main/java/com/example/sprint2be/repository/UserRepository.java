package com.example.sprint2be.repository;

import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findAllByUsername(String username);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail (String email);
}
