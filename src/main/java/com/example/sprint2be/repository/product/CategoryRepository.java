package com.example.sprint2be.repository.product;

import com.example.sprint2be.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
