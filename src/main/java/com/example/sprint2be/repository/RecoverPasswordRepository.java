package com.example.sprint2be.repository;

import com.example.sprint2be.model.user.RecoverPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecoverPasswordRepository extends JpaRepository<RecoverPassword,Integer> {
    Optional<RecoverPassword> findByUsername (String username);
    Optional<RecoverPassword> findByConfirmCode (String confirmCode);
}
