package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    void save(Cart cart);

    List<Cart> findAll();

    Optional<Cart> findCartByUserId(Integer id);

    Optional<Cart> findById(Integer cartId);

    Double updateTotalPrice(Integer idCart);

}
