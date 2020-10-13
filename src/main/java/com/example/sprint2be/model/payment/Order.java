package com.example.sprint2be.model.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column
    private String orderCode;

    @Column
    private String paymentMethod;

    @Column
    private String deliveryDate;

    @Column
    private String paymentAddress;

    @Column
    private String orderStatus;

    @ManyToOne(targetEntity = Cart.class)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    public Order() {
    }

    public Order(String orderCode, String paymentMethod, String deliveryDate, String paymentAddress, String orderStatus,
                 Cart cart) {
        this.orderCode = orderCode;
        this.paymentMethod = paymentMethod;
        this.deliveryDate = deliveryDate;
        this.paymentAddress = paymentAddress;
        this.orderStatus = orderStatus;
        this.cart = cart;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
