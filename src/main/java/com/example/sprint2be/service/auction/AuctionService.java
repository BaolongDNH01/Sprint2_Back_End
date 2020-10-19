package com.example.sprint2be.service.auction;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.dto.AuctionDto;
import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.Product;

import java.util.List;

public interface AuctionService {
    List<Auction> findAll();
    Auction findById(Integer auctionId);
    void save(Auction auction);
    void delete(Integer auctionId);
    List<AuctionDto> findAllAuctionDto();
    void saveAuctionDto(AuctionDto auctionDto);
    AuctionDto findByIdDto(Integer auctionId);
    AuctionDto findAuctionByProduct(Product product);
}
