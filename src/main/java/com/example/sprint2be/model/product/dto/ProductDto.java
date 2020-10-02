package com.example.sprint2be.model.product.dto;

import java.util.List;

public class ProductDto {
    private Integer productId;
    private String productName;
    private Double initialPrice;
    private Double eachIncrease;
    private String image;
    private String productDetail;
    private Integer category_id;
    private Integer status_id;
    private Integer time_id;
    private Integer user_id;
    private List<Integer> auctionList_id;

    public ProductDto() {

    }

    public ProductDto(Integer productId, String productName, Double initialPrice, Double eachIncrease, String image,
                      String productDetail, Integer category_id, Integer status_id, Integer time_id, Integer user_id,
                      List<Integer> auctionList) {
        this.productId = productId;
        this.productName = productName;
        this.initialPrice = initialPrice;
        this.eachIncrease = eachIncrease;
        this.image = image;
        this.productDetail = productDetail;
        this.category_id = category_id;
        this.status_id = status_id;
        this.time_id = time_id;
        this.user_id = user_id;
        this.auctionList_id = auctionList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Double getEachIncrease() {
        return eachIncrease;
    }

    public void setEachIncrease(Double eachIncrease) {
        this.eachIncrease = eachIncrease;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Integer getTime_id() {
        return time_id;
    }

    public void setTime_id(Integer time_id) {
        this.time_id = time_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<Integer> getAuctionList_id() {
        return auctionList_id;
    }

    public void setAuctionList_id(List<Integer> auctionList_id) {
        this.auctionList_id = auctionList_id;
    }
}
