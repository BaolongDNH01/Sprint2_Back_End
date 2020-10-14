package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.product.Product;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Column
    private int quantity;

    @Column
    private double winPrice;

    @OneToOne
    @JoinColumn(name = "auction_id")
    @JsonIgnore
    private Auction auction;

    @Column
    private String cartItemStatus;

    // Relationship with Cart
    @ManyToOne(targetEntity = Cart.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
//    @JsonBackReference
    private Cart cart;

    // Relationship with Product
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    @JsonManagedReference

//    @JsonIdentityReference(alwaysAsId = true)
    private Product product;

    public CartItem() {
    }

    public CartItem(int quantity, double winPrice, Auction auction, String cartItemStatus, Cart cart, Product product) {
        this.quantity = quantity;
        this.winPrice = winPrice;
        this.auction = auction;
        this.cartItemStatus = cartItemStatus;
        this.cart = cart;
        this.product = product;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWinPrice() {
        return winPrice;
    }

    public void setWinPrice(double winPrice) {
        this.winPrice = winPrice;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String getCartItemStatus() {
        return cartItemStatus;
    }

    public void setCartItemStatus(String cartItemStatus) {
        this.cartItemStatus = cartItemStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

