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
    private String imageURL;
    private Integer auctionTime;
    private List<Integer> bidderListId;

    public AuctionDto() {

    }

    public AuctionDto(Integer auctionId, String dayTimeStart, String dayTimeEnd, Integer status_id,
                      Integer product_id, List<Integer> bidderList_id) {
        this.auctionId = auctionId;
        this.dayTimeStart = dayTimeStart;
        this.dayTimeEnd = dayTimeEnd;
        this.statusId = status_id;
        this.productId = product_id;
        this.bidderListId = bidderList_id;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Integer> getBidderListId() {
        return bidderListId;
    }

    public void setBidderListId(List<Integer> bidderListId) {
        this.bidderListId = bidderListId;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Integer auctionTime) {
        this.auctionTime = auctionTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
