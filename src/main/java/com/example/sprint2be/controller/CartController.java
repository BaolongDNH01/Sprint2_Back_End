package com.example.sprint2be.controller;

import com.example.sprint2be.exceptions.ResourceNotFoundException;
import com.example.sprint2be.model.payment.*;
import com.example.sprint2be.service.payment.CartItemService;
import com.example.sprint2be.service.payment.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    // Thien: Load cart by user id
    @GetMapping("/get/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer userId) throws ResourceNotFoundException {
        Cart cart = cartService
                .findCartByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        for(CartItem item : cart.getCartItemList()) {
            System.out.println(item.getProduct().getProductName());
        }
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/get-response/{userId}")
    public ResponseEntity<CartResponseDTO> getCartByUserId2(@PathVariable Integer userId)  {
        CartResponseDTO cartResponseDTO = cartService.parse(userId);
        return ResponseEntity.ok(cartResponseDTO);
    }

    // Thien:  Add product to cart
    @PostMapping("/add")
    public ResponseEntity<CartItem> addProductToCart(@RequestBody CartItemDTO cartItemDTO) throws ResourceNotFoundException {
        CartItem cartItem = cartItemService.parse(cartItemDTO);
        if (cartItem != null) {
            return ResponseEntity.ok().body(cartItem);
        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    // Delete item of cart
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<CartItem> deleteCartItem(@PathVariable Integer cartItemId) throws ResourceNotFoundException {

        CartItem cartItem = cartItemService.delete(cartItemId);
        if (cartItem != null) {
            return ResponseEntity.ok().body(cartItem);
        } else {
            throw new ResourceNotFoundException("Resource not found: [" + cartItemId + "]");
        }
    }

    // Chau => GetAllCart and GetAllCartItem
    @GetMapping("/getAllCart")
    public ResponseEntity<List<CartDTO>> getAllCartDto() {
        return new ResponseEntity<>(this.cartService.findAllCartDto(), HttpStatus.OK);
    }

    @GetMapping("/getAllCartItem")
    public ResponseEntity<List<CartItemDTO>> getAllCartItemDto() {
        System.out.println("vo day roi nghe");
        return new ResponseEntity<>(this.cartItemService.findAllCartItemDto(), HttpStatus.OK);
    }

    @PostMapping("/removeCartItem")
    public void removeCartItem(@RequestBody Integer[] cartIds) {
        for (int delCart : cartIds){
            cartItemService.deleteCartItemById(delCart);
        }
    }
}
