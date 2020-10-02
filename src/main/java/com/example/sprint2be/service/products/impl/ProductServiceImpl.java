package com.example.sprint2be.service.products.impl;

import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.StatusProduct;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.service.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private ProductDto convertToProductDto(Product product){
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setInitialPrice(product.getInitialPrice());
            productDto.setEachIncrease(product.getEachIncrease());
            productDto.setImage(product.getImage());
            productDto.setProductDetail(product.getProductDetail());

        Category category = product.getCategory();
        productDto.setCategoryId(category.getCategoryId());

        AuctionTime auctionTime = product.getAuctionTime();
        productDto.setTimeId(auctionTime.getTimeId());

        StatusProduct statusProduct = product.getStatusProduct();
        productDto.setStatusId(statusProduct.getStatusId());

        User user = product.getUser_product();
        productDto.setUserId(user.getUserId());

            return productDto;


    }


    @Override
    public List<ProductDto> findAllProduct() {
        return (productRepository.findAll().stream().map(this::convertToProductDto).collect(Collectors.toList()));
    }

    @Override
    public ProductDto findById(Integer id) {
        return (productRepository.findById(id).map(this::convertToProductDto).orElse(null));
    }
}
