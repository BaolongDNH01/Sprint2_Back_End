package com.example.sprint2be.repository.payment;

import com.example.sprint2be.model.payment.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findCartByUser_UserId(Integer userId);
}
