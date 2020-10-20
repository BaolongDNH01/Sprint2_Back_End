package com.example.sprint2be.repository.payment;

import com.example.sprint2be.model.payment.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findCartByUser_UserId(Integer userId);

    @Query(
            value = "select bidder.user_id, bidder.bid_price, auction.product_id" +
                    " from bidder" +
                    " join auction on auction.auction_id=bidder.auction_id" +
                    " where auction.status_id=3" +
                    " group by bidder.auction_id, bidder.user_id" +
                    " having bidder.bid_price in (" +
                    "select max(bidder.bid_price) as max_price" +
                    " from bidder" +
                    " join auction on auction.auction_id=bidder.auction_id" +
                    " where auction.status_id=3" +
                    " group by bidder.auction_id" +
                    "    having user_id=?1" +
                    ");", nativeQuery = true)
    ArrayList<Integer[]> getInfoProductWonList(Integer userId);
}
