package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;
<<<<<<< HEAD
import com.example.sprint2be.model.payment.CartDto;
import com.example.sprint2be.model.payment.CartItem;
=======
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63

import java.util.List;
import java.util.Optional;

public interface CartService {

    void save(Cart cart);

    List<Cart> findAll();

<<<<<<< HEAD
    void addItemToCart(CartItem item);

    Optional<Cart> findById(Integer cartId);

    Double updateTotalPrice(Integer idCart);

    Optional<Cart> findCartByUserId(Integer id);

    // chau
    List<CartDto> findAllCartDto();
=======
    Optional<Cart> findCartByUserId(Integer id);

    Optional<Cart> findById(Integer cartId);

    Double updateTotalPrice(Integer idCart);

>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
}
