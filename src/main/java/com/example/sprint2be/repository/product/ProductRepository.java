package com.example.sprint2be.repository.product;

import com.example.sprint2be.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
