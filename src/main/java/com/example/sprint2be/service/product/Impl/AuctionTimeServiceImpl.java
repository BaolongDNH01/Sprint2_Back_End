package com.example.sprint2be.service.product.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.repository.product.AuctionTimeRepository;
import com.example.sprint2be.service.product.AuctionTimeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuctionTimeServiceImpl implements AuctionTimeService {
    @Autowired
    AuctionTimeRepository auctionTimeRepository;
    @Override
    public List<AuctionTime> findAll() {
        return auctionTimeRepository.findAll();
    }

    @Override
    public AuctionTime findById(Integer auctionTimeId) {
        return auctionTimeRepository.findById(auctionTimeId).orElse(null);
    }

    @Override
    public void save(AuctionTime auctionTime) {
        auctionTimeRepository.save(auctionTime);
    }

    @Override
    public void delete(Integer auctionTimeId) {
        auctionTimeRepository.deleteById(auctionTimeId);
    }

}
