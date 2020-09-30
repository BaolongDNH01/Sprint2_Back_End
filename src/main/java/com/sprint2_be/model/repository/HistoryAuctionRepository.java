package com.sprint2_be.model.repository;

import com.sprint2_be.model.entity.HistoryAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryAuctionRepository extends JpaRepository<HistoryAuction,Integer> {

}
