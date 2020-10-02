package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.StatusAuction;
import com.example.sprint2be.repository.auction.StatusAuctionRepository;
import com.example.sprint2be.service.auction.StatusAuctionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StatusAuctionServiceImpl implements StatusAuctionService {
    @Autowired
    StatusAuctionRepository statusAuctionRepository;

    @Override
    public List<StatusAuction> findAll() {
        return statusAuctionRepository.findAll();
    }

    @Override
    public StatusAuction findById(Integer statusAuctionId) {
        return statusAuctionRepository.findById(statusAuctionId).orElse(null);
    }

    @Override
    public void save(StatusAuction statusAuction) {
        statusAuctionRepository.save(statusAuction);
    }

    @Override
    public void delete(Integer statusAuctionId) {
        statusAuctionRepository.deleteById(statusAuctionId);
    }
}
