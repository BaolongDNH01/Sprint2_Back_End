package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.StatusProduct;

import java.util.List;

public interface StatusProductService {
    List<StatusProduct> findAll();
    StatusProduct findById(Integer statusProductId);
    void save(StatusProduct statusProduct);
    void delete(Integer statusProductId);
}
