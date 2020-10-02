package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.StatusAuction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusAuctionRepository extends JpaRepository<StatusAuction,Integer> {
}
