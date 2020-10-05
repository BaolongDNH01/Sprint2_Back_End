package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProduct();
    ProductDto findById(Integer id);
    void save(Product product);
    void delete(Integer productId);
}
