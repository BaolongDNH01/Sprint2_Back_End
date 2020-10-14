package com.example.sprint2be.model.payment;

public class CartDTO {
    private Integer cartId;
    private double currentTotalPrice;
    private String cartStatus;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public double getCurrentTotalPrice() {
        return currentTotalPrice;
    }

    public void setCurrentTotalPrice(double totalPrice) {
        this.currentTotalPrice = totalPrice;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String status) {
        this.cartStatus = status;
    }
}
