package com.example.sprint2be.controller;

import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.service.payment.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    // Load cart by user id
    @GetMapping("/cart/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) throws Exception {
        Cart cart = cartService
                .findCartByUserId(userId)
                .orElseThrow(() -> new Exception("Cart not found"));
        return ResponseEntity.ok(cart);
    }

    // Update Total cost of cart

    // Add product to cart
    @PostMapping("/cart/add")
    public ResponseEntity<CartItem> addProductToCart(
            @RequestBody CartItem cartItem
    ) {
        CartItem item;
        return null;

    }


    // Update quantity of cart item

    // Delete item of cart

}
