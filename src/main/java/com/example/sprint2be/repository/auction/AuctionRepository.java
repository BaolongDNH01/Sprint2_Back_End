package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction,Integer> {

//    khanh
    Auction findAuctionByBidderListContaining(Bidder bidder);
}
