package com.sprint2_be.service.impl;

import com.sprint2_be.model.entity.HistoryRegister;
import com.sprint2_be.model.repository.HistoryRegisterRepository;
import com.sprint2_be.service.HistoryRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryRegisterServiceImpl implements HistoryRegisterService {

    @Autowired
    private HistoryRegisterRepository historyRegisterRepository;


    @Override
    public List<HistoryRegister> findAll() {
        return historyRegisterRepository.findAll();
    }
}
