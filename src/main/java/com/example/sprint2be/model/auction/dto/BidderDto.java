package com.example.sprint2be.model.auction.dto;

public class BidderDto {

    private Integer bidId;
    private Double bidPrice;
    private String bidDateTime;
    private Integer auctionId;
    private Integer userId;

    public BidderDto() {

    }

    public BidderDto(Integer bidId, Double bidPrice, String bidDateTime, Integer auction_id, Integer user_id) {
        this.bidId = bidId;
        this.bidPrice = bidPrice;
        this.bidDateTime = bidDateTime;
        this.auctionId = auction_id;
        this.userId = user_id;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidDateTime() {
        return bidDateTime;
    }

    public void setBidDateTime(String bidDateTime) {
        this.bidDateTime = bidDateTime;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
