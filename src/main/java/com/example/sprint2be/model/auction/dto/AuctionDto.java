package com.example.sprint2be.model.auction.dto;

import java.util.List;

public class AuctionDto {

    private Integer auctionId;
    private String dayTimeStart;
    private String dayTimeEnd;
    private Integer statusId;
    private String statusName;
    private Integer productId;
    private String productName;
    private Double eachIncrease;
    private Integer auctionTime;
    private List<Integer> bidderListId;
    private Double initialPrice;
    private String ImageURL;
    private String categoryName;

    public AuctionDto() {

    }

    public AuctionDto(Integer auctionId, String dayTimeStart, String dayTimeEnd, Integer statusId, String statusName, Integer productId, String productName, Double eachIncrease, Integer auctionTime, List<Integer> bidderListId, Double initialPrice, String imageURL, String categoryName) {
        this.auctionId = auctionId;
        this.dayTimeStart = dayTimeStart;
        this.dayTimeEnd = dayTimeEnd;
        this.statusId = statusId;
        this.statusName = statusName;
        this.productId = productId;
        this.productName = productName;
        this.eachIncrease = eachIncrease;
        this.auctionTime = auctionTime;
        this.bidderListId = bidderListId;
        this.initialPrice = initialPrice;
        ImageURL = imageURL;
        this.categoryName = categoryName;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getDayTimeStart() {
        return dayTimeStart;
    }

    public void setDayTimeStart(String dayTimeStart) {
        this.dayTimeStart = dayTimeStart;
    }

    public String getDayTimeEnd() {
        return dayTimeEnd;
    }

    public void setDayTimeEnd(String dayTimeEnd) {
        this.dayTimeEnd = dayTimeEnd;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public Double getEachIncrease() {
        return eachIncrease;
    }

    public void setEachIncrease(Double eachIncrease) {
        this.eachIncrease = eachIncrease;
    }

    public Integer getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Integer auctionTime) {
        this.auctionTime = auctionTime;
    }

    public List<Integer> getBidderListId() {
        return bidderListId;
    }

    public void setBidderListId(List<Integer> bidderListId) {
        this.bidderListId = bidderListId;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
