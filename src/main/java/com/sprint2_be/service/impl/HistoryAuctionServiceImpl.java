package com.sprint2_be.service.impl;

import com.sprint2_be.model.entity.HistoryAuction;
import com.sprint2_be.model.repository.HistoryAuctionRepository;
import com.sprint2_be.service.HistoryAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryAuctionServiceImpl implements HistoryAuctionService {

    @Autowired
    private HistoryAuctionRepository historyAuctionRepository;

    @Override
    public List<HistoryAuction> findAll() {
        return historyAuctionRepository.findAll();
    }
}
