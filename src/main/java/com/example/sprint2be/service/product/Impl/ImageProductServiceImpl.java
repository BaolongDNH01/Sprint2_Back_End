package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.repository.product.ImageProductRepository;
import com.example.sprint2be.service.product.ImageProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageProductServiceImpl implements ImageProductService {
    @Autowired
    ImageProductRepository imageProductRepository;
    @Override
    public List<ImageProduct> findAll() {
        return imageProductRepository.findAll();
    }

    @Override
    public ImageProduct findById(Integer imageId) {
        return imageProductRepository.findById(imageId).orElse(null);
    }

    @Override
    public void save(ImageProduct imageProduct) {
        imageProductRepository.save(imageProduct);
    }

    @Override
    public void delete(Integer imageId) {
        imageProductRepository.deleteById(imageId);
    }
}
