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
    private Double currentTotalPrice;

    //Thien: This field is setting for locked / unlocked user
    @Column
    private String cartStatus;

    // Relationship with User
    @OneToOne(mappedBy = "cart", cascade = CascadeType.DETACH)
    @JsonBackReference
    private User user;

    // Thien: Setup relationship Order
    @OneToMany(mappedBy = "cart", cascade = CascadeType.DETACH)
    private List<Order> listOrder;

    // Thien: Relationship with CartItem (1-n)
    @OneToMany(mappedBy = "cart", cascade = CascadeType.DETACH)
    @JsonIgnoreProperties(value = "cart")
    private List<CartItem> cartItemList;

    public Cart() {
    }

    public Cart(Double currentTotalPrice, String cartStatus, User user, List<Order> listOrder, List<CartItem> cartItemList) {
        this.currentTotalPrice = currentTotalPrice;
        this.cartStatus = cartStatus;
        this.user = user;
        this.listOrder = listOrder;
        this.cartItemList = cartItemList;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getCurrentTotalPrice() {
        return currentTotalPrice;
    }

    public void setCurrentTotalPrice(Double currentTotalPrice) {
        this.currentTotalPrice = currentTotalPrice;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
