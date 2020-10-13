package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;

import java.util.List;

public interface CartItemService {

    List<CartItem> findAll();

    CartItem parse(CartItemDTO cartItemDTO);


    // Thien: return CartItem to set status: deleted
    CartItem delete(Integer cartItemId);

    // Chau : removeCartItem
    void deleteCartItemById(Integer cartItemId);

    // chau : findAllCartIteam
    List<CartItemDTO> findAllCartItemDto();
}
