package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartDto;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
import com.example.sprint2be.repository.payment.CartRepository;
import com.example.sprint2be.service.payment.constant.ECartItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    private CartDto convertToCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setShipCost(cart.getShipCost());
        cartDto.setStatus(cart.isStatus());
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }

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
    public List<CartDto> findAllCartDto() {
        return (this.cartRepository.findAll().stream().map(this::convertToCartDto).collect(Collectors.toList()));
    }
}
