package com.example.sprint2be.controller;

import com.example.sprint2be.exceptions.ResourceNotFoundException;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
import com.example.sprint2be.service.payment.CartItemService;
import com.example.sprint2be.service.payment.CartService;
import javassist.NotFoundException;
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

    // Thien: Load cart by user id
    @GetMapping("/cart/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer userId) throws Exception {
        Cart cart = cartService
                .findCartByUserId(userId)
                .orElseThrow(() -> new Exception("Cart not found"));
        return ResponseEntity.ok(cart);
    }

    // Thien:  Update Total cost of cart

    // Thien:  Add product to cart
    @PostMapping("/cart/add")
    public ResponseEntity<CartItem> addProductToCart(@RequestBody CartItemDTO cartItemDTO) throws ResourceNotFoundException {
        CartItem cartItem = cartItemService.create(cartItemDTO);
        if (cartItem != null) {
            return ResponseEntity.ok().body(cartItem);
        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }


    // Update quantity of cart item

    // Delete item of cart

}
