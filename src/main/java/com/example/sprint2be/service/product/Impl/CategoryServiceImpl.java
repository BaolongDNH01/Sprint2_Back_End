package com.example.sprint2be.service.product.Impl;


import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.dto.CategoryDto;
import com.example.sprint2be.repository.product.CategoryRepository;
import com.example.sprint2be.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<CategoryDto> findAllCategoryDto() {
        return categoryRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
}
