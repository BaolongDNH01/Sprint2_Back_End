package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;

import com.example.sprint2be.model.payment.CartDTO;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartResponseDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CartService {

    void save(Cart cart);

    List<Cart> findAll();

    Optional<Cart> findById(Integer cartId);

    //Thien
    Optional<Cart> findCartByUserId(Integer id);
    ArrayList<Integer[]> getInfoProductWonList(Integer userId);

    // chau
    List<CartDTO> findAllCartDto();
}
