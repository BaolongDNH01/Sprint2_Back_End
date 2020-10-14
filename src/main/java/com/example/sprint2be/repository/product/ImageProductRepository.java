package com.example.sprint2be.repository.product;

import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageProductRepository extends JpaRepository<ImageProduct,Integer> {

    List<ImageProduct>findImageProductsByProduct(Product product);
}
