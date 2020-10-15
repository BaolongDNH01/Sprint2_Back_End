package com.example.sprint2be.controller;

import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.BidderDto;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.product.*;
import com.example.sprint2be.model.product.dto.CategoryDto;
import com.example.sprint2be.model.product.dto.ImageProductDto;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.model.product.dto.StatusProductDto;
import com.example.sprint2be.repository.auction.BidderRepository;
import com.example.sprint2be.service.auction.BidderService;
import com.example.sprint2be.service.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    StatusProductService statusProductService;

    @Autowired
    ImageProductService imageProductService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AuctionTimeService auctionTimeService;

    @Autowired
    BidderService bidderService;

    @Autowired
    BidderRepository bidderRepository;
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto product, UriComponentsBuilder builder) {
//        khanh them truong ngay post san pham
        String month = "";
        if(java.time.LocalDateTime.now().getMonthValue() < 10){
            month = "0" + java.time.LocalDateTime.now().getMonthValue();
        }else {
            month = "" + java.time.LocalDateTime.now().getMonthValue();
        }

        String date = "";
        if(java.time.LocalDateTime.now().getMonthValue() < 10){
            date = "0" + java.time.LocalDateTime.now().getDayOfMonth();
        }else {
            date = "" + java.time.LocalDateTime.now().getDayOfMonth();
        }

        String year = "" + java.time.LocalDateTime.now().getYear();

        String datePostProduct = year + "-" + month + "-" + date;

        product.setDatePost(datePostProduct);
        productService.saveProductDto(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/edit-product")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        productService.saveProductDto(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/list-product")
    public ResponseEntity<List<ProductDto>> getListProduct() {
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/product/image/{id}")
    public ResponseEntity<ImageProductDto> findImageById(@PathVariable Integer id) {
        return new ResponseEntity<>(imageProductService.findByIdImageDto(id), HttpStatus.OK);
    }
    @PatchMapping("/product-edit/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDtoForm) {
        Product product = productService.findByIdProduct(id);
        productDtoForm.setProductId(product.getProductId());
        productService.saveProductDto(productDtoForm);
        return new ResponseEntity<>("update", HttpStatus.OK);
    }

    @GetMapping("/list-status")
    public ResponseEntity<List<StatusProductDto>> getListStatus() {
        return new ResponseEntity<>(statusProductService.findAllStatusProduct(), HttpStatus.OK);
    }

    @GetMapping("/list-image-product")
    public ResponseEntity<List<ImageProductDto>> getAllImage() {
        return new ResponseEntity<>(imageProductService.findAllDto(), HttpStatus.OK);
    }


    @GetMapping("/getAllProductByUserName/{userName}")
    public ResponseEntity<List<ProductDto>> getAllProductByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(productService.findAllProductByUser(userName), HttpStatus.OK);
    }


    @GetMapping("/list-category")
    public ResponseEntity<List<Category>> getListCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list-time")
    public ResponseEntity<List<AuctionTime>> getListAuctionTime() {
        return new ResponseEntity<>(auctionTimeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllCategoryDto")
    public ResponseEntity<List<CategoryDto>> getAllCategoryDto() {
        return new ResponseEntity<>(categoryService.findAllCategoryDto(), HttpStatus.OK);
    }

    @PostMapping("/deleteProducts")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProducts(@RequestBody Integer[] list) {
        for (int delCount : list) {
            productService.delete(delCount);
        }
    }

    // Châu => GetAllCartByBidder
    @GetMapping("/getAllCartByBidder")
    public ResponseEntity<List<UserBidderDto>> getAllCart() {
        return new ResponseEntity<>(bidderRepository.getAllCart(), HttpStatus.OK);
    }

    @PostMapping("/create-image")
    public ResponseEntity<ImageProduct> createImage(@RequestBody ImageProductDto image, UriComponentsBuilder builder) {
        imageProductService.saveDto(image);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-image/{id}").buildAndExpand(image.getImageId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



    @GetMapping("/changStatusProductToPost/{id}")
    public void changStatusProductToPost(@PathVariable Integer id){
        Product product = productService.findByIdProduct(id);
        StatusProduct statusProduct = statusProductService.findById(1);
        product.setStatusProduct(statusProduct);
        productService.saveProductDto(product);
    }

    @GetMapping(value = "/get-image-product/{id}")
    public ResponseEntity<List<ImageProductDto>> getListImage(@PathVariable("id") Integer id) {
        List<ImageProductDto> imageProductDtos = imageProductService.findImageProductsByProduct(id);
        return new ResponseEntity<>(imageProductDtos, HttpStatus.OK);
    }

    @GetMapping("/get-bidder-max/{id}")
    public ResponseEntity<Integer> getBidderMax(@PathVariable Integer id) {
        return new ResponseEntity<>(bidderRepository.getMaxBidderByAuctionId(id), HttpStatus.OK);
    }
}


