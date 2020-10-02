package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidderRepository extends JpaRepository<Bidder,Integer> {
}
