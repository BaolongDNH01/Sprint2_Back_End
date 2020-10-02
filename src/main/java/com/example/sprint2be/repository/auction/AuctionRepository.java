package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction,Integer> {
}
