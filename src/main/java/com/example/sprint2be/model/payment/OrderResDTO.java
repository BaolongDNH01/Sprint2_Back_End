package com.example.sprint2be.model.payment;

public class OrderResDTO {


    private String deliveryDate;

    private String orderCode;

    private String  orderStatus;

    public OrderResDTO() {
    }

    public OrderResDTO(String deliveryDate, String orderCode, String orderStatus) {
        this.deliveryDate = deliveryDate;
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
