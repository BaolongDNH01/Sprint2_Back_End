package com.example.sprint2be.controller;

import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.Category;
import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.CategoryDto;
import com.example.sprint2be.model.product.dto.ImageProductDto;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.model.product.dto.StatusProductDto;
import com.example.sprint2be.service.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto product, UriComponentsBuilder builder) {
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
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        System.out.println("okokok");
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
    public ResponseEntity<ImageProductDto> findImageById(@PathVariable Integer id){
        return new ResponseEntity<>(imageProductService.findByIdImageDto(id),HttpStatus.OK);
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
    public ResponseEntity<List<ProductDto>> getAllProductByUserName(@PathVariable String userName){
        return new ResponseEntity<>(productService.findAllProductByUser(userName), HttpStatus.OK);
    }


    @GetMapping("/list-category")
    public ResponseEntity<List<Category>> getListCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list-time")
    public ResponseEntity<List<AuctionTime>> getListAuctionTime(){
        return new ResponseEntity<>(auctionTimeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllCategoryDto")
    public ResponseEntity<List<CategoryDto>> getAllCategoryDto(){
        return new ResponseEntity<>(categoryService.findAllCategoryDto(), HttpStatus.OK);
    }

    @PostMapping("/deleteProducts")
    public void deleteProducts(@RequestBody Integer[] list){
        for (int delCount: list) {
            productService.delete(delCount);
        }
    }
}
