package com.example.sprint2be.controller;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.service.product.ProductService;
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

    @PostMapping("/create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list-product")
    public ResponseEntity<List<ProductDto>> getListProduct(){
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
}
