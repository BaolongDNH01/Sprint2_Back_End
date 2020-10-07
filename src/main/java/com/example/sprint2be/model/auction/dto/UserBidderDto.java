package com.example.sprint2be.model.auction.dto;

public class UserBidderDto {
    private Integer productId;
    private String productName;
    private String productDetail;
    private Double priceBidder;
    private String dateBidder;
    private String auctionStatus;
    private String cancellerAuction;

    public UserBidderDto() {
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

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public Double getPriceBidder() {
        return priceBidder;
    }

    public void setPriceBidder(Double priceBidder) {
        this.priceBidder = priceBidder;
    }

    public String getDateBidder() {
        return dateBidder;
    }

    public void setDateBidder(String dateBidder) {
        this.dateBidder = dateBidder;
    }

    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public String getCancellerAuction() {
        return cancellerAuction;
    }

    public void setCancellerAuction(String cancellerAuction) {
        this.cancellerAuction = cancellerAuction;
    }
}
