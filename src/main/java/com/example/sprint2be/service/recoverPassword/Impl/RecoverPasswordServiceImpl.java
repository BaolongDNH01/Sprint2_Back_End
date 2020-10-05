package com.example.sprint2be.service.recoverPassword.Impl;

import com.example.sprint2be.model.user.RecoverPassword;
import com.example.sprint2be.repository.RecoverPasswordRepository;
import com.example.sprint2be.service.recoverPassword.RecoverPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecoverPasswordServiceImpl implements RecoverPasswordService {
    @Autowired
    RecoverPasswordRepository recoverPasswordRepository;

    @Override
    public void save(RecoverPassword recoverPassword) {
        recoverPasswordRepository.save(recoverPassword);
    }

    @Override
    public Optional<RecoverPassword> loadByUsername(String username) {
        return recoverPasswordRepository.findByUsername(username);
    }

    @Override
    public void delete(RecoverPassword recoverPassword) {
        recoverPasswordRepository.delete(recoverPassword);
    }

    @Override
    public Optional<RecoverPassword> loadByConfirmCode(String confirmCode) {
        return recoverPasswordRepository.findByConfirmCode(confirmCode);
    }
}
