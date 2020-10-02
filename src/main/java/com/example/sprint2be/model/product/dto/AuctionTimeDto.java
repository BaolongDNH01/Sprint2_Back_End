package com.example.sprint2be.model.product.dto;

import java.util.List;

public class AuctionTimeDto {

    private Integer timeId;

    private Integer auctionTime;

    private List<Integer> productList_id;

    public AuctionTimeDto() {

    }

    public AuctionTimeDto(Integer timeId, Integer auctionTime, List<Integer> productList) {
        this.timeId = timeId;
        this.auctionTime = auctionTime;
        this.productList_id = productList;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Integer getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Integer auctionTime) {
        this.auctionTime = auctionTime;
    }

    public List<Integer> getProductList_id() {
        return productList_id;
    }

    public void setProductList_id(List<Integer> productList_id) {
        this.productList_id = productList_id;
    }
}
