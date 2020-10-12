package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.payment.CartItemRepository;
import com.example.sprint2be.repository.payment.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem create(CartItemDTO cartItemDTO) {
        Optional<User> optionalUser = userRepository.findById(cartItemDTO.getUserId());

        if (!optionalUser.isPresent()) {
            return null;
        }

        Optional<Cart> optionalCart = cartRepository.findCartByUser_UserId(cartItemDTO.getUserId());
        Cart cart;

        if (optionalCart.isPresent()) {
            cart = new Cart();
            cart.setUser(optionalUser.get());
        } else {
            cart = optionalCart.get();
        }

        Optional<Auction> optionalAuction = auctionRepository.findById(cartItemDTO.getAuctionId());

        if (!optionalAuction.isPresent()) {
            return null;
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setWinPrice(cartItemDTO.getWinPrice());
        cartItem.setQuantity(1);
        cartItem.setAuction(optionalAuction.get());
        cartItem.setDeleted(false);
        cartItem.setStatus("Loading...");

        cartItemRepository.save(cartItem);

//        cartService.updateTotalCost(cart.getId());

        return cartItem;
    }
}
