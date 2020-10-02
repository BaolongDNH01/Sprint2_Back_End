package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.repository.auction.BidderRepository;
import com.example.sprint2be.service.auction.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidderServiceImpl implements BidderService {
    @Autowired
    BidderRepository bidderRepository;
    @Override
    public List<Bidder> findAll() {
        return bidderRepository.findAll();
    }

    @Override
    public Bidder findById(Integer bidderId) {
        return bidderRepository.findById(bidderId).orElse(null);
    }

    @Override
    public void save(Bidder bidder) {
        bidderRepository.save(bidder);
    }

    @Override
    public void delete(Integer bidderId) {
        bidderRepository.deleteById(bidderId);
    }
}
