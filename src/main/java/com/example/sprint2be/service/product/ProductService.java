package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer productId);
    void save(Product product);
    void delete(Integer productId);
}
