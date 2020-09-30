package com.sprint2_be.controller;

import com.sprint2_be.model.entity.HistoryRegister;
import com.sprint2_be.service.HistoryRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/historyRegister")
public class HistoryRegisterController {

    @Autowired
    private HistoryRegisterService historyRegisterService;

    @GetMapping("")
    public List<HistoryRegister> getAllHistoryRegister() {
        List<HistoryRegister> historyRegister;
        historyRegister = historyRegisterService.findAll();
        return historyRegister;
    }

}
