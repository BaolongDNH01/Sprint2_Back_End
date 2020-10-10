package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Column
    private boolean isDeleted;

    @Column
    private int quantity;

    @Column
    private double winPrice;

    @OneToOne
    @JoinColumn(name = "auction_id")
    @JsonIgnore
    private Auction auction;

    @Column
    private String status;

    @Column
    private Double cartItemCost;

    // Relationship with Cart
    @ManyToOne(targetEntity = Cart.class)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    // Relationship with Product
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public CartItem() {
    }

    public CartItem(boolean isDeleted, int quantity, double winPrice, Auction auction, String status, Double cartItemCost, Cart cart, Product product) {
        this.isDeleted = isDeleted;
        this.quantity = quantity;
        this.winPrice = winPrice;
        this.auction = auction;
        this.status = status;
        this.cartItemCost = cartItemCost;
        this.cart = cart;
        this.product = product;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCartItemCost() {
        return cartItemCost;
    }

    public void setCartItemCost(Double cartItemCost) {
        this.cartItemCost = cartItemCost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

