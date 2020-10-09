package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.StatusAuction;
import com.example.sprint2be.model.auction.dto.AuctionDto;
import com.example.sprint2be.model.product.AuctionTime;
import com.example.sprint2be.model.product.ImageProduct;
import com.example.sprint2be.model.product.Product;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.auction.StatusAuctionRepository;
import com.example.sprint2be.repository.product.ProductRepository;
import com.example.sprint2be.service.auction.AuctionService;
import com.example.sprint2be.service.auction.StatusAuctionService;
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

    @Autowired
    StatusAuctionService statusAuctionService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StatusAuctionRepository statusAuctionRepository;


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

        StatusAuction statusAuction = auction.getStatusAuction();
        auctionDto.setStatusId(statusAuction.getStatusId());
        auctionDto.setStatusName(statusAuction.getStatusName());

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

    // Chau => find auction By id
    @Override
    public AuctionDto findByIdDto(Integer auctionId) {
        return (auctionRepository.findById(auctionId).map(this::convertToAuctionDto).orElse(null));
    }

    // Chau => Update status auction
    @Override
    public void saveAuctionDto(AuctionDto auctionDto) {
        Auction auction = new Auction();
        auction.setAuctionId(auctionDto.getAuctionId());
        auction.setDayTimeStart(auctionDto.getDayTimeStart());
        auction.setDayTimeEnd(auctionDto.getDayTimeEnd());
        auction.setProduct(productRepository.findById(auctionDto.getProductId()).orElse(null));
        auction.setStatusAuction(statusAuctionRepository.findById(auctionDto.getStatusId()).orElse(null));

        auctionRepository.save(auction);
    }
}
