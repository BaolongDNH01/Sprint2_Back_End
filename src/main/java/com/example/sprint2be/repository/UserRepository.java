package com.example.sprint2be.repository;

import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
