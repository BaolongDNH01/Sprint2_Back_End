package com.sprint2_be.service;

import com.sprint2_be.model.entity.HistoryAuction;
import com.sprint2_be.model.entity.HistoryRegister;

import java.util.List;

public interface HistoryAuctionService {
    List<HistoryAuction> findAll();
}
