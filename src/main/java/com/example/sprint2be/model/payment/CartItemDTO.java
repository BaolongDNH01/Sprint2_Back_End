package com.example.sprint2be.model.payment;

import javax.validation.constraints.NotNull;

public class CartItemDTO {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer auctionId;

    @NotNull
    private Double winPrice;

    public CartItemDTO() {
    }

    public CartItemDTO(@NotNull Integer auctionId, @NotNull Double winPrice) {
        this.auctionId = auctionId;
        this.winPrice = winPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Double getWinPrice() {
        return winPrice;
    }

    public void setWinPrice(Double winPrice) {
        this.winPrice = winPrice;
    }
}
