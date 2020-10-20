package com.example.sprint2be.repository.product;

import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

//    khanh
    List<Product> findProductsByUserId(User user);

    Optional<Product> findProductByUserId(Integer userId);
    List<Product> findProductsByCategory(Category category);
}
