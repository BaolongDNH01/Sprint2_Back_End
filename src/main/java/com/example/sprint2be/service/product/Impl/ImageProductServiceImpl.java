package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.ImageProductDto;
import com.example.sprint2be.repository.product.ImageProductRepository;
import com.example.sprint2be.service.product.ImageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageProductServiceImpl implements ImageProductService {
    @Autowired
    ImageProductRepository imageProductRepository;

    private ImageProductDto convertToImageDto (ImageProduct imageProduct){
            ImageProductDto imageProductDto = new ImageProductDto();
            imageProductDto.setImageId(imageProduct.getImageId());
            imageProductDto.setImageURL(imageProduct.getImageURL());

        Product product = imageProduct.getProduct();
        imageProductDto.setProductId(product.getProductId());


        return imageProductDto;
    }

    @Override
    public List<ImageProduct> findAll() {
        return imageProductRepository.findAll();
    }

    @Override
    public List<ImageProductDto> findAllDto() {
        return (imageProductRepository.findAll().stream().map(this::convertToImageDto).collect(Collectors.toList()));
    }

    @Override
    public ImageProduct findById(Integer imageId) {
        return imageProductRepository.findById(imageId).orElse(null);
    }

    @Override
    public ImageProductDto findByIdImageDto(Integer imageId) {
        return (imageProductRepository.findById(imageId).map(this::convertToImageDto).orElse(null));
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
