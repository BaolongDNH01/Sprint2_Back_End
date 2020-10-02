package com.example.sprint2be.model.product.dto;

import java.util.List;

public class CategoryDto {
    private Integer categoryId;
    private String categoryName;
    private List<Integer> productList_id;

    public CategoryDto() {

    }

    public CategoryDto(Integer categoryId, String categoryName, List<Integer> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productList_id = product;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Integer> getProductList_id() {
        return productList_id;
    }

    public void setProductList_id(List<Integer> productList_id) {
        this.productList_id = productList_id;
    }
}
