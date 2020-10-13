package com.example.sprint2be.model.payment;

import javax.validation.constraints.NotNull;

public class OrderDTO {

    @NotNull
    private Integer cartId;

    @NotNull
    private String orderCode;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String paymentAddress;

    @NotNull
    private String orderStatus;

    @NotNull
    private String deliveryDate;

    public OrderDTO() {
    }

    public OrderDTO(Integer cartId, String orderCode, String paymentMethod, String paymentAddress, String orderStatus,
                    String deliveryDate) {
        this.cartId = cartId;
        this.orderCode = orderCode;
        this.paymentMethod = paymentMethod;
        this.paymentAddress = paymentAddress;
        this.orderStatus = orderStatus;
        this.deliveryDate = deliveryDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public void setPaymentAddress(String deliveryMethod) {
        this.paymentAddress = deliveryMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
