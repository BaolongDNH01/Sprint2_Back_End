package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer categoryId);
    void save(Category category);
    void delete(Integer categoryId);
}
