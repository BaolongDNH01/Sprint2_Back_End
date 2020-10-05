package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.ImageProduct;

import java.util.List;

public interface ImageProductService {
    List<ImageProduct> findAll();
    ImageProduct findById(Integer imageId);
    void save(ImageProduct imageProduct);
    void delete(Integer imageId);
}
