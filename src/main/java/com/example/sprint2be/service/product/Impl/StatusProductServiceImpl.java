package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.StatusProduct;
import com.example.sprint2be.repository.product.StatusProductRepository;
import com.example.sprint2be.service.product.StatusProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusProductServiceImpl implements StatusProductService {
    @Autowired
    StatusProductRepository statusProductRepository;
    @Override
    public List<StatusProduct> findAll() {
        return statusProductRepository.findAll();
    }

    @Override
    public StatusProduct findById(Integer statusProductId) {
        return statusProductRepository.findById(statusProductId).orElse(null);
    }

    @Override
    public void save(StatusProduct statusProduct) {
        statusProductRepository.save(statusProduct);
    }

    @Override
    public void delete(Integer statusProductId) {
        statusProductRepository.deleteById(statusProductId);
    }
}
