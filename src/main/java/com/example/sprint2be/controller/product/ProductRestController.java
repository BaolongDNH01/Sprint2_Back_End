package com.example.sprint2be.controller.product;

import com.example.sprint2be.model.product.dto.ProductDto;
import com.example.sprint2be.service.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/list-product")
        public ResponseEntity<List<ProductDto>> getListProduct(){
            return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
        }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

}
