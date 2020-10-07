package com.example.sprint2be.repository.product;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

//    khanh
    List<Product> findProductsByUserId(User user);
}
