package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;

import java.util.List;

public interface CartItemService {

    List<CartItem> findAll();

    CartItem create(CartItemDTO cartItemDTO);

    // chau
    List<CartItemDTO> findAllCartItemDto();

}
