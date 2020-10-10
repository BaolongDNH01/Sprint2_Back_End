package com.example.sprint2be.model.auction.dto;

public class BidderDto {

    private Integer bidId;
    private Double bidPrice;
    private String bidDateTime;
    private Integer auctionId;
    private Integer userId;
    private String userName;

    public BidderDto() {

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
