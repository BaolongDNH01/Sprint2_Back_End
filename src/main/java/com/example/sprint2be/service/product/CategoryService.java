package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer categoryId);
    void save(Category category);
    void delete(Integer categoryId);

//    khanh
    List<CategoryDto> findAllCategoryDto();
}
