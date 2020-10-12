package com.example.sprint2be.service.auction;

import com.example.sprint2be.model.auction.StatusAuction;
import com.example.sprint2be.model.auction.dto.StatusAuctionDto;

import java.util.List;

public interface StatusAuctionService {
    List<StatusAuction> findAll();
    StatusAuction findById(Integer statusAuctionId);
    void save(StatusAuction statusAuction);
    void delete(Integer statusAuctionId);
    // Chau => GetAllStatusAuction
    List<StatusAuctionDto> findAllStatusAuctionDto();
}
