package com.example.sprint2be.repository;

import com.example.sprint2be.model.HistoryAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryAuctionRepository extends JpaRepository<HistoryAuction,Integer> {

}
