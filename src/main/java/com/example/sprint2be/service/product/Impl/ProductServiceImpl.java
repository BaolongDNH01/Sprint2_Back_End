package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }
}
