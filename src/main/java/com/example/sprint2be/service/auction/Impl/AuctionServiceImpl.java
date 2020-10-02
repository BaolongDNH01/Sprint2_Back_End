package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.service.auction.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    AuctionRepository auctionRepository;
    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findById(Integer auctionId) {
        return auctionRepository.findById(auctionId).orElse(null);
    }

    @Override
    public void save(Auction auction) {
        auctionRepository.save(auction);
    }

    @Override
    public void delete(Integer auctionId) {
        auctionRepository.deleteById(auctionId);
    }
}
