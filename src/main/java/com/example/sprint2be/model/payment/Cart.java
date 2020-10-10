package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column
    private double totalPrice = 0;

    @Column
    private double shipCost = 0;

    @Column
    private boolean status;

    // Relationship with User
    @OneToOne(mappedBy = "cart")
    @JsonBackReference
    private User user;

    // Relationship with CartItem (1-n)
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "cart")
    private List<CartItem> cartItemList;

    public Cart() {
    }

    public Cart(double totalPrice, double shipCost, boolean status, User user, List<CartItem> cartItemList) {
        this.totalPrice = totalPrice;
        this.shipCost = shipCost;
        this.status = status;
        this.user = user;
        this.cartItemList = cartItemList;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getShipCost() {
        return shipCost;
    }

    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
