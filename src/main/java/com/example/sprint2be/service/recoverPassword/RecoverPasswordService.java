package com.example.sprint2be.service.recoverPassword;

import com.example.sprint2be.model.user.RecoverPassword;

import java.util.Optional;

public interface RecoverPasswordService {
    void save(RecoverPassword recoverPassword);
    Optional<RecoverPassword> loadByUsername(String username);
    void delete(RecoverPassword recoverPassword);
    Optional<RecoverPassword> loadByConfirmCode(String confirmCode);
}
