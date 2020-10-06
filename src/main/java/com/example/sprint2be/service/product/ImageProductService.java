package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.dto.ImageProductDto;

import java.util.List;

public interface ImageProductService {
    List<ImageProduct> findAll();
    List<ImageProductDto> findAllDto();
    ImageProduct findById(Integer imageId);
    ImageProductDto findByIdImageDto(Integer imageId);
    void save(ImageProduct imageProduct);
    void delete(Integer imageId);
}
