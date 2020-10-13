package com.example.sprint2be.service.payment.impl;

import com.example.sprint2be.model.constant.ECartItemStatus;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.repository.payment.CartRepository;
import com.example.sprint2be.service.payment.CartService;
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
    public Optional<Cart> findCartByUserId(Integer id) {
        Optional<Cart> optionalCart = cartRepository.findCartByUser_UserId(id);
        double totalPrice = 0.0;
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            List<CartItem> cartItemsList = cart.getCartItemList();
            cartItemsList.removeIf(item -> !item.getStatus().equals(ECartItemStatus.ITEM_ENABLED.name()));
            totalPrice += cart.getShipCost();

            for(CartItem item : cartItemsList) {
                totalPrice += item.getWinPrice();
            }
            cart.setTotalPrice(totalPrice);
            cartRepository.save(cart);
        }
        return optionalCart;
    }

    @Override
    public Optional<Cart> findById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Double updateTotalPrice(Integer idCart) {
        Optional<Cart> optionalCart = cartRepository.findById(idCart);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            double totalPriceUpdate = 0.0;

            for (CartItem item : cart.getCartItemList()) {
                if (item.getStatus().equalsIgnoreCase(ECartItemStatus.ITEM_ENABLED.name())) {
                    totalPriceUpdate += item.getWinPrice();
                }
            }
            cart.setTotalPrice(totalPriceUpdate);
            cartRepository.save(cart);
            return totalPriceUpdate;
        }
        return null;
    }
}
