package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartDto;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
import com.example.sprint2be.repository.payment.CartRepository;
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
    public Optional<Cart> findCartByUserId(Integer id) {
        return cartRepository.findCartByUser_UserId(id);
    }

    @Override
    public List<CartDto> findAllCartDto() {
        return (this.cartRepository.findAll().stream().map(this::convertToCartDto).collect(Collectors.toList()));
    }
}
