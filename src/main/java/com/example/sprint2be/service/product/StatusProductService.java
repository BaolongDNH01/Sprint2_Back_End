package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.StatusProduct;
import com.example.sprint2be.model.product.dto.StatusProductDto;

import java.util.List;

public interface StatusProductService {
    List<StatusProduct> findAll();
    List<StatusProductDto> findAllStatusProduct();
    StatusProduct findById(Integer statusProductId);
    void save(StatusProduct statusProduct);
    void delete(Integer statusProductId);
}
