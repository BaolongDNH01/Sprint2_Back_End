package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction,Integer> {

//    khanh
    Auction findAuctionByBidderListContaining(Bidder bidder);

//    chau
    Optional<Auction> findAuctionByProduct(Product product);
}
