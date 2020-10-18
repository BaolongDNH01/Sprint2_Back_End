package com.example.sprint2be.service.payment.impl;

import com.example.sprint2be.model.constant.ECartItemStatus;
import com.example.sprint2be.model.constant.ECartStatus;
import com.example.sprint2be.model.constant.EOrderStatus;
import com.example.sprint2be.model.payment.*;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.payment.OrderRepository;
import com.example.sprint2be.service.payment.CartService;
import com.example.sprint2be.service.payment.OrderService;
import com.example.sprint2be.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Override
    public Optional<Order> findOrderByCartId(Integer cartId) {
        return orderRepository.findOrderByCart_CartId(cartId);
    }

    @Override
    public OrderResDTO save(OrderDTO orderDTO) {
        ModelMapper mapper = new ModelMapper();
        Order order = mapper.map(orderDTO, Order.class);
        Cart cart = cartService.findById(orderDTO.getCartId()).orElse(null);

        // Thien: cartId == userId
        User owner = userService.findByIdUser(orderDTO.getCartId());

        if (cart != null) {
            List<CartItem> cartItemsList = cart.getCartItemList();
            cartItemsList.removeIf(item -> item.getCartItemStatus().equals(ECartItemStatus.ITEM_REMOVED.name()));
            for (CartItem item : cartItemsList) {
                item.setCartItemStatus(ECartItemStatus.ITEM_PAID.name());
            }

            order.setCart(cart);
            order.setOrderStatus(EOrderStatus.ORDER_ASSIGNED.name());
            order.setDeliveryDate((LocalDate.now().plusDays(3)).toString());
            order.setOrderCode("ORD" + Math.random() * 1000000);

            orderRepository.save(order);


            cart.setCartStatus(ECartStatus.CART_ENABLED.name());
            cart.setCurrentTotalPrice(0.0);
            owner.setCart(cart);
        }
        OrderResDTO orderResponse = new OrderResDTO();
        orderResponse.setDeliveryDate(order.getDeliveryDate());
        orderResponse.setOrderCode(order.getOrderCode());
        orderResponse.setOrderStatus(order.getOrderStatus());
        return orderResponse;
    }
}
