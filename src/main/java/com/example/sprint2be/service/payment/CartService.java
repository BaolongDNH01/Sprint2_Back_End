package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartService {

    void save(Cart cart);

    List<Cart> findAll();

    void addItemToCart(CartItem item);

    Optional<Cart> findCartByUserId(Long id);

}
