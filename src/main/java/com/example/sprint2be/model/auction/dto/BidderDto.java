package com.example.sprint2be.model.auction.dto;

public class BidderDto {

    private Integer bidId;
    private Double bidPrice;
    private String bidDateTime;
    private Integer auction_id;
    private Integer user_id;

    public BidderDto() {

    }

    public BidderDto(Integer bidId, Double bidPrice, String bidDateTime, Integer auction_id, Integer user_id) {
        this.bidId = bidId;
        this.bidPrice = bidPrice;
        this.bidDateTime = bidDateTime;
        this.auction_id = auction_id;
        this.user_id = user_id;
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

    public Integer getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Integer auction_id) {
        this.auction_id = auction_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
