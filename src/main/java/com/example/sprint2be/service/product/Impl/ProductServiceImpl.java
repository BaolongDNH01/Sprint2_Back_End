package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.*;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.product.AuctionTimeRepository;
import com.example.sprint2be.repository.product.CategoryRepository;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.repository.product.StatusProductRepository;
import com.example.sprint2be.service.product.ProductService;
import com.example.sprint2be.service.product.StatusProductService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private ProductDto convertToProductDto(Product product) {
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

        User user = product.getUserId();
        productDto.setUserId(user.getUserId());
        productDto.setFullName(user.getFullName());

        List<ImageProduct> imageProductList = product.getImageProductList();
        List<Integer> id = new ArrayList<>();
        String imgUrl = null;
        for (ImageProduct img : imageProductList) {
            id.add(img.getImageId());
            imgUrl = img.getImageURL();
        }
        productDto.setImageURL(imgUrl);
        productDto.setListImageProduct(id);
        productDto.setDatePost(product.getDatePost());

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
        product.setUserId(userRepository.findByUsername(productDto.getFullName()).orElse(null));
        productRepository.save(product);

        System.out.println("da toi");
    }


    @Autowired
    UserRepository userRepository;

    @Override
    public List<ProductDto> findAllProductByUser(String userName) {
        User user = userRepository.findByUsername(userName).orElse(new User());
        return productRepository.findProductsByUserId(user).stream().map(this::convertToProductDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findProductByUserId(Integer userId) {
        return productRepository.findProductByUserId(userId);
    }
}
