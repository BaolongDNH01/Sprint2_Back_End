package com.example.sprint2be.service.payment;

import com.example.sprint2be.model.payment.Order;
import com.example.sprint2be.model.payment.OrderDTO;
import com.example.sprint2be.model.payment.OrderResDTO;

import java.util.Optional;

public interface OrderService {

    Optional<Order> findOrderByCartId(Integer cartId);

    OrderResDTO save(OrderDTO orderDTO);
}
