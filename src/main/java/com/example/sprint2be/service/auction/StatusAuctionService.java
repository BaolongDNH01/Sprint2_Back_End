package com.example.sprint2be.service.auction;

import com.example.sprint2be.model.auction.StatusAuction;

import java.util.List;

public interface StatusAuctionService {
    List<StatusAuction> findAll();
    StatusAuction findById(Integer statusAuctionId);
    void save(StatusAuction statusAuction);
    void delete(Integer statusAuctionId);
}
