package com.example.sprint2be.service.payment.impl;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartDTO;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.repository.payment.CartRepository;
import com.example.sprint2be.service.payment.CartService;
import com.example.sprint2be.service.payment.constant.ECartItemStatus;
import com.example.sprint2be.service.payment.constant.ECartStatus;
import com.example.sprint2be.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    // Chau
    private CartDTO convertToCartDto(Cart cart) {
        CartDTO cartDto = new CartDTO();
        cartDto.setCartId(cart.getCartId());
        // Thien: Change field of this table
        // cartDto.setShipCost(cart.getShipCost());

        cartDto.setCartStatus(cart.getCartStatus());
        cartDto.setCurrentTotalPrice(cart.getCurrentTotalPrice());
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
    public Optional<Cart> findById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Double updateTotalPrice(Integer idCart) {
        Optional<Cart> optionalCart = cartRepository.findById(idCart);
//        if (optionalCart.isPresent()) {
//            Cart cart = optionalCart.get();
//            double totalPriceUpdate = 0.0;
//
//            for (CartItem item : cart.getCartItemList()) {
//                if (item.getStatus().equalsIgnoreCase(ECartItemStatus.ITEM_ENABLED.name())) {
//                    totalPriceUpdate += item.getWinPrice();
//                }
//            }
//            cart.setTotalPrice(totalPriceUpdate);
//            cartRepository.save(cart);
//            return totalPriceUpdate;
//        }
        return null;
    }

    @Override
    public Optional<Cart> findCartByUserId(Integer id) {
        Optional<Cart> optionalCart = cartRepository.findCartByUser_UserId(id);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            double total = 0.0;

            // Thien: Check cart empty
            if(cart.getCartItemList().isEmpty()) {
                cart.setCartStatus(ECartStatus.CART_EMPTY.name());
                cart.setCurrentTotalPrice(total);
            } else {
                cart.setCartStatus(ECartStatus.CART_EXIST_ITEM.name());
                List<CartItem> cartItemsList = cart.getCartItemList();

                cartItemsList.removeIf(item -> item.getCartItemStatus().equalsIgnoreCase(ECartItemStatus.ITEM_REMOVED.name()));

                for(CartItem item : cartItemsList) {
                    total += item.getWinPrice();
                }
            }
            cart.setCurrentTotalPrice(total);
            save(cart);
        }
        return optionalCart;
    }

    @Override
    public List<CartDTO> findAllCartDto() {
        return (this.cartRepository.findAll().stream().map(this::convertToCartDto).collect(Collectors.toList()));
    }
}
