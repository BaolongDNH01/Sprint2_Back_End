package com.example.sprint2be.model.payment;

import com.example.sprint2be.model.product.Product;

import java.util.List;

public class CartResponseDTO {

    private Integer cartId;

    private Double currentTotalPrice;

    private String cartStatus;

    private List<Order> listOrder;

    private List<CartItem> cartItemList;

    private List<Product> productList;

    public CartResponseDTO() {
    }

    public CartResponseDTO(Double currentTotalPrice, String cartStatus, List<Order> listOrder, List<CartItem> cartItemList, List<Product> productList) {
        this.currentTotalPrice = currentTotalPrice;
        this.cartStatus = cartStatus;
        this.listOrder = listOrder;
        this.cartItemList = cartItemList;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
