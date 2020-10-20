package com.example.sprint2be.service.payment.impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartDTO;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.CartResponseDTO;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.payment.CartItemRepository;
import com.example.sprint2be.repository.payment.CartRepository;
import com.example.sprint2be.service.payment.CartService;
import com.example.sprint2be.model.constant.ECartItemStatus;
import com.example.sprint2be.model.constant.ECartStatus;
import com.example.sprint2be.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductService productService;

    @Autowired
    AuctionRepository auctionRepository;

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
    public Optional<Cart> findCartByUserId(Integer id) {

        Optional<Cart> optionalCart = cartRepository.findCartByUser_UserId(id);



        if (optionalCart.isPresent()) {
            ArrayList<Integer[]> productInfoList = cartRepository.getInfoProductWonList(id);
            Integer winPrice = productInfoList.get(0)[1];
            Integer idProduct = productInfoList.get(0)[2];
            Product productWon = productService.findByIdProduct(idProduct);
            Optional<Auction> auction = auctionRepository.findAuctionByProduct(productWon);


            Cart cart = optionalCart.get();
            List<CartItem> cartItemsList = cart.getCartItemList();

            double total = 0.0;

            CartItem itemWon = new CartItem();
            if(auction.isPresent()) {
                itemWon.setAuction(auction.get());
            }

            itemWon.setCart(cart);
            itemWon.setCartItemStatus(ECartItemStatus.ITEM_ENABLED.name());
            itemWon.setWinPrice(winPrice);
            itemWon.setProduct(productWon);
            itemWon.setQuantity(1);

//            cartItemRepository.save(itemWon);

            cartItemsList.add(itemWon);
            cartItemsList.removeIf(item -> item.getCartItemStatus().equalsIgnoreCase(ECartItemStatus.ITEM_PAID.name()));

            // Thien: Check cart empty
            if (cart.getCartItemList().isEmpty()) {
                cart.setCartStatus(ECartStatus.CART_EMPTY.name());
                cart.setCurrentTotalPrice(total);
            } else {
                cart.setCartStatus(ECartStatus.CART_EXIST_ITEM.name());

                cartItemsList.removeIf(item -> item.getCartItemStatus().equalsIgnoreCase(ECartItemStatus.ITEM_REMOVED.name()));

                for (CartItem item : cartItemsList) {
                    if(item.getCartItemStatus().equalsIgnoreCase(ECartItemStatus.ITEM_ENABLED.name())) {
                        total += item.getWinPrice();
                    }
                }
            }
            cart.setCurrentTotalPrice(total);
            save(cart);
        }
        return optionalCart;
    }

    @Override
    public ArrayList<Integer[]> getInfoProductWonList(Integer userId) {
        return cartRepository.getInfoProductWonList(userId);
    }

    @Override
    public List<CartDTO> findAllCartDto() {
        return (this.cartRepository.findAll().stream().map(this::convertToCartDto).collect(Collectors.toList()));
    }
}
