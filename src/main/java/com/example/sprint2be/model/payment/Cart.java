package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column
    private Double shipCost;

    @Column
    private Double totalPrice;

    //Thien: This field is setting for locked / unlocked user
    @Column
    private boolean status;

    // Relationship with User
    @OneToOne(mappedBy = "cart")
    @JsonBackReference
    private User user;

    // Thien: Setup relationship Order
    @OneToMany(mappedBy = "cart")
    private Set<Order> orderSet;

    // Relationship with CartItem (1-n)
    @OneToMany(mappedBy = "cart", cascade = CascadeType.DETACH)
    @JsonIgnoreProperties(value = "cart")
    private List<CartItem> cartItemList;

    // Thien: Setup relationship Order
    @OneToMany(mappedBy = "cart")
    private Set<Order> orderSet;

    public Cart() {
    }

<<<<<<< HEAD
    public Cart(double totalPrice, double shipCost, boolean status, User user, List<CartItem> cartItemList, Set<Order> orderSet) {
        this.totalPrice = totalPrice;
=======
    public Cart(Double shipCost, Double totalPrice, boolean status, User user, List<CartItem> cartItemList, Set<Order> orderSet) {
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
        this.shipCost = shipCost;
        this.totalPrice = totalPrice;
        this.status = status;
        this.user = user;
        this.cartItemList = cartItemList;
        this.orderSet = orderSet;
<<<<<<< HEAD
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
=======
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getShipCost() {
        return shipCost;
    }

    public void setShipCost(Double shipCost) {
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
