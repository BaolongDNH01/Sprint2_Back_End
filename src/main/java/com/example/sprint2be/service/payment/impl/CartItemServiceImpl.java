package com.example.sprint2be.service.payment.impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.constant.ECartItemStatus;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartItemDTO;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.auction.BidderRepository;
import com.example.sprint2be.repository.payment.CartItemRepository;
import com.example.sprint2be.repository.payment.CartRepository;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.service.auction.BidderService;
import com.example.sprint2be.service.payment.CartItemService;
import com.example.sprint2be.service.payment.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BidderRepository bidderRepository;

    @Autowired
    BidderService bidderService;

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }


    @Override
    public CartItem parse(CartItemDTO cartItemDTO) {
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
        cartItem.setStatus(ECartItemStatus.ITEM_ENABLED.name());

        cartService.updateTotalPrice(cart.getCartId());
        cartItemRepository.save(cartItem);

        return cartItem;
    }

    // Thien: This method is use to set status of item: deleted, not really deleted it
    @Override
    public CartItem delete(Integer cartItemId) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isPresent()) {
            CartItem cartItem =cartItemOptional.get();
            cartItem.setStatus(ECartItemStatus.ITEM_REMOVED.name());
            cartService.updateTotalPrice(cartItem.getCart().getCartId());
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    @Override
    public void deleteCartItemById(Integer cartItemId) {
        this.cartItemRepository.deleteById(cartItemId);
    }

    private CartItemDTO convertToCartItemDto(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setCartItemId(cartItem.getCartItemId());

        User user ;
        user = this.userRepository.findById(cartItem.getProduct().getUserId().getUserId()).orElse(null);
        cartItemDTO.setUserName(user.getFullName());
        cartItemDTO.setUserId(user.getUserId());

        cartItemDTO.setProductId(cartItem.getProduct().getProductId());
        cartItemDTO.setProductName(cartItem.getProduct().getProductName());

        UserBidderDto userBidderDto;


        cartItemDTO.setAuctionId(cartItem.getAuction().getAuctionId());

        return cartItemDTO;
    }


    @Override
    public List<CartItemDTO> findAllCartItemDto() {
        return (cartItemRepository.findAll().stream().map(this::convertToCartItemDto).collect(Collectors.toList()));
    }
}
