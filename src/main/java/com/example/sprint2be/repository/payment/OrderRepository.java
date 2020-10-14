package com.example.sprint2be.repository.payment;

import com.example.sprint2be.model.payment.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findOrderByCart_CartId(Integer cartId);
}
