package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Column
    private boolean isDeleted;

    @Column
    private int quantity;

    // Relationship with Cart
    @ManyToOne(targetEntity = Cart.class)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnoreProperties(value = "cartItemList")
    private Cart cart;

    // Relationship with Product
    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    public CartItem() {
    }

    public CartItem(boolean isDeleted, int quantity, Cart cart, Product product) {
        this.isDeleted = isDeleted;
        this.quantity = quantity;
        this.cart = cart;
        this.product = product;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
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

}

