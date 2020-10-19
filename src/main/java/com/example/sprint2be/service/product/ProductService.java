package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> findAllProduct();
    ProductDto findById(Integer id);
    void saveProductDto(Product product);
    void delete(Integer productId);
    Product findByIdProduct(Integer id);
    void saveProductDto(ProductDto productDto);
    void saveProductDto2(ProductDto productDto);

//    khanh
    List<ProductDto> findAllProductByUser(String userName);

    // Thien
    Optional<Product> findProductByUserId(Integer userId);
//    Long
    void editProduct(ProductDto productDto);

//    chau moi them
    List<Product> findProductByCategory(Category category);
}
