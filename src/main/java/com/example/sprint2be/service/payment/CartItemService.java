package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;

import java.util.List;

public interface CartItemService {

    List<CartItem> findAll();

<<<<<<< HEAD
    CartItem create(CartItemDTO cartItemDTO);
=======
    CartItem parse(CartItemDTO cartItemDTO);
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63

    // Thien: return CartItem to set status: deleted
    CartItem delete(Integer cartItemId);

<<<<<<< HEAD
    // chau
    List<CartItemDTO> findAllCartItemDto();

=======
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
}
