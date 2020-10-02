package com.example.sprint2be.service.product;

import com.example.sprint2be.model.product.AuctionTime;

import java.util.List;

public interface AuctionTimeService {
    List<AuctionTime> findAll();
    AuctionTime findById(Integer auctionTimeId);
    void save(AuctionTime auctionTime);
    void delete(Integer auctionTimeId);
}
