package com.example.sprint2be.controller;

import com.example.sprint2be.exceptions.ResourceNotFoundException;
import com.example.sprint2be.model.payment.Order;
import com.example.sprint2be.model.payment.OrderDTO;
import com.example.sprint2be.repository.payment.OrderRepository;
import com.example.sprint2be.service.payment.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/order/{cartId}")
    public ResponseEntity<Order> getOrderByUserId(@PathVariable Integer cartId) {
        Optional<Order> optionalOrder = orderRepository.findOrderByCart_CartId(cartId);
        return optionalOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create-order")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
