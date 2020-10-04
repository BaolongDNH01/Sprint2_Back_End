package com.example.sprint2be.controller;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/edit-product")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
