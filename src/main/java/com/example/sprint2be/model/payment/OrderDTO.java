package com.example.sprint2be.model.payment;

import javax.validation.constraints.NotNull;

public class OrderDTO {

    @NotNull
    private Integer cartId;

    @NotNull
    private String shipMethod;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String paymentAddress;

    @NotNull
    private Double shipCost;

    @NotNull
    private Double totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(@NotNull String shipMethod, @NotNull String paymentMethod, @NotNull String paymentAddress,
                    @NotNull Double shipCost, @NotNull Double totalPrice) {
        this.shipMethod = shipMethod;
        this.paymentMethod = paymentMethod;
        this.paymentAddress = paymentAddress;
        this.shipCost = shipCost;
        this.totalPrice = totalPrice;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public Double getShipCost() {
        return shipCost;
    }

    public void setShipCost(Double shipCost) {
        this.shipCost = shipCost;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
