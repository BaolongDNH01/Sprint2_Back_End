package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.StatusProduct;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.product.AuctionTimeRepository;
import com.example.sprint2be.repository.product.CategoryRepository;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.repository.product.StatusProductRepository;
import com.example.sprint2be.service.product.ProductService;
import com.example.sprint2be.service.product.StatusProductService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StatusProductRepository statusProductRepository;

    @Autowired
    StatusProductService statusProductService;

    @Autowired
    AuctionTimeRepository auctionTimeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserService userService;

    private ProductDto convertToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setInitialPrice(product.getInitialPrice());
        productDto.setEachIncrease(product.getEachIncrease());
        productDto.setProductDetail(product.getProductDetail());


        Category category = product.getCategory();
        productDto.setCategoryId(category.getCategoryId());
        productDto.setCategoryName(category.getCategoryName());

        AuctionTime auctionTime = product.getAuctionTime();
        productDto.setTimeId(auctionTime.getTimeId());
        productDto.setAuctionTime(auctionTime.getAuctionTime());

        StatusProduct statusProduct = product.getStatusProduct();
        productDto.setStatusId(statusProduct.getStatusId());
        productDto.setStatusName(statusProduct.getStatusName());

        User user = product.getUser_product();
        productDto.setUserId(user.getUserId());
        productDto.setFullName(user.getFullName());

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

    @Override
    public void saveProductDto(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product findByIdProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProductDto(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setInitialPrice(productDto.getInitialPrice());
        product.setEachIncrease(productDto.getEachIncrease());
//        product.setImage(productDto.getImage());
        product.setProductDetail(productDto.getProductDetail());
        product.setStatusProduct(statusProductRepository.findById(productDto.getStatusId()).orElse(null));
        product.setAuctionTime(auctionTimeRepository.findById(productDto.getTimeId()).orElse(null));
        product.setCategory(categoryRepository.findById(productDto.getCategoryId()).orElse(null));
        product.setUser_product(userService.findByIdUser(productDto.getUserId()));
        productRepository.save(product);

        System.out.println("da toi");
    }
}
