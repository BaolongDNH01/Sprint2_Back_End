package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.product.StatusProduct;
import com.example.sprint2be.model.product.dto.StatusProductDto;
import com.example.sprint2be.repository.product.StatusProductRepository;
import com.example.sprint2be.service.product.StatusProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusProductServiceImpl implements StatusProductService {
    @Autowired
    StatusProductRepository statusProductRepository;

    private StatusProductDto convertToStatusProductDto(StatusProduct statusProduct){
        StatusProductDto statusProductDto = new StatusProductDto();
        statusProductDto.setStatusId(statusProduct.getStatusId());
        statusProductDto.setStatusName(statusProduct.getStatusName());
//
        List<Product> productList = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        for (Product product : productList){
            id.add(product.getProductId());
        }
        statusProductDto.setProductList_Id(id);
        return statusProductDto;
    }

    @Override
    public List<StatusProduct> findAll() {
        return statusProductRepository.findAll();
    }

    @Override
    public List<StatusProductDto> findAllStatusProduct() {
        return (statusProductRepository.findAll()).stream().map(this::convertToStatusProductDto).collect(Collectors.toList());
    }

    @Override
    public StatusProduct findById(Integer statusProductId) {
        return statusProductRepository.findById(statusProductId).orElse(null);
    }

    @Override
    public void save(StatusProduct statusProduct) {
        statusProductRepository.save(statusProduct);
    }

    @Override
    public void delete(Integer statusProductId) {
        statusProductRepository.deleteById(statusProductId);
    }
}
