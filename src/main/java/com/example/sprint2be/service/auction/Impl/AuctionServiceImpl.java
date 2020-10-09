package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.dto.AuctionDto;
import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.service.auction.AuctionService;
import com.example.sprint2be.service.product.AuctionTimeService;
import com.example.sprint2be.service.product.ImageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    ImageProductService imageProductService;

    @Autowired
    AuctionTimeService auctionTimeService;

    private AuctionDto convertToAuctionDto(Auction auction) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setAuctionId(auction.getAuctionId());
        auctionDto.setDayTimeStart(auction.getDayTimeStart());
        auctionDto.setDayTimeEnd(auction.getDayTimeEnd());

        Product product = auction.getProduct();
        auctionDto.setProductId(product.getProductId());
        auctionDto.setProductName(product.getProductName());
        auctionDto.setEachIncrease(product.getEachIncrease());

        ImageProduct imageProduct = this.imageProductService.findById(product.getProductId());
        auctionDto.setImageURL(imageProduct.getImageURL());

        AuctionTime auctionTime = this.auctionTimeService.findById(product.getProductId());
        auctionDto.setAuctionTime(auctionTime.getAuctionTime());

        return auctionDto;
    }

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

    @Override
    public List<AuctionDto> findAllAuctionDto() {
        return (auctionRepository.findAll().stream().map(this::convertToAuctionDto).collect(Collectors.toList()));
    }

}
