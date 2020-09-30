package com.sprint2_be.service.impl;

import com.sprint2_be.model.entity.Information;
import com.sprint2_be.model.repository.InformationRepository;
import com.sprint2_be.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationRepository informationRepository;
    @Override
    public List<Information> findAll() {
        return informationRepository.findAll();
    }

    @Override
    public Information findById(Integer id) {
        return informationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Information information) {

    }

    @Override
    public void delete(Integer id) {

    }
}
