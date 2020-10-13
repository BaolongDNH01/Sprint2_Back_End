package com.example.sprint2be.controller;

import com.example.sprint2be.exceptions.ResourceNotFoundException;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartDto;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
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
<<<<<<< HEAD
    @GetMapping("/cart/{userId}")
=======
    @GetMapping("/get/{userId}")
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer userId) throws ResourceNotFoundException {
        Cart cart = cartService
                .findCartByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        return ResponseEntity.ok(cart);
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

<<<<<<< HEAD
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
    public ResponseEntity<List<CartDto>> getAllCartDto() {
        return new ResponseEntity<>(this.cartService.findAllCartDto(), HttpStatus.OK);
    }

    @GetMapping("/getAllCartItem")
    public ResponseEntity<List<CartItemDTO>> getAllCartItemDto() {
        return new ResponseEntity<>(this.cartItemService.findAllCartItemDto(), HttpStatus.OK);
    }

=======
    // Thien: Update quantity of cart item

    // Thien: Delete item of cart
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<CartItem> deleteCartItem(@PathVariable Integer cartItemId) throws ResourceNotFoundException{
        CartItem cartItem = cartItemService.delete(cartItemId);
        if(cartItem != null) {
            return ResponseEntity.ok().body(cartItem);
        } else {
            throw new ResourceNotFoundException("Resource not found: [" + cartItemId + "]");
        }
    }
>>>>>>> e4900ec99bed5c3d855eaca80b74c0182aeddd63
}
