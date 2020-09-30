package com.sprint2_be.service;

import com.sprint2_be.model.entity.Information;

import java.util.List;

public interface InformationService {
    List<Information> findAll();

    Information findById(Integer id);

    void save(Information information);

    void delete(Integer id);
}
