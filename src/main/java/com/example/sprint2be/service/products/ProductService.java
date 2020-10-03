package com.example.sprint2be.service.products;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProduct();
    ProductDto findById(Integer id);
}
