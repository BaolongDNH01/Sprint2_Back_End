package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.repository.payment.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void addItemToCart(CartItem item) {
    }

    @Override
    public Optional<Cart> findCartByUserId(Long id) {
        return cartRepository.findCartByUser_UserId(id);
    }
}
