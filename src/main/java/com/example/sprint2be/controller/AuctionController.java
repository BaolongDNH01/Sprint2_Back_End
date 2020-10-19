package com.example.sprint2be.controller;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.StatusAuction;
import com.example.sprint2be.model.auction.dto.AuctionDto;
import com.example.sprint2be.model.auction.dto.BidderDto;
import com.example.sprint2be.model.auction.dto.StatusAuctionDto;
import com.example.sprint2be.service.auction.AuctionService;
import com.example.sprint2be.service.auction.BidderService;
import com.example.sprint2be.service.auction.StatusAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class AuctionController {
    @Autowired
    AuctionService auctionService;

    @Autowired
    BidderService bidderService;

    @Autowired
    StatusAuctionService statusAuctionService;
    @PostMapping("/create-auction")
    public ResponseEntity<Auction> createProduct(@RequestBody AuctionDto auction, UriComponentsBuilder builder) {
        auctionService.saveAuctionDto(auction);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-auction/{id}").buildAndExpand(auction.getAuctionId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-bidder-auction/{id}")
    public ResponseEntity<List<BidderDto>> getListBidder(@PathVariable("id") Integer id) {
        List<BidderDto> bidders = bidderService.findBiddersByAuctionOrderByBidPriceDesc(id);
        return new ResponseEntity<>(bidders, HttpStatus.OK);
    }


    @GetMapping("/getAllAuction")
    public ResponseEntity<List<AuctionDto>> getAllAution() {
        return new  ResponseEntity<>(this.auctionService.findAllAuctionDto(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    @PostMapping("/create-bidder")
    public ResponseEntity<Bidder> createBidder(@RequestBody BidderDto bidder, UriComponentsBuilder builder) {
        bidderService.saveDto(bidder);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-bidder/{id}").buildAndExpand(bidder.getBidId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/auction-edit/{id}")
    public ResponseEntity<String> updateStatusAuction(@PathVariable Integer id, @RequestBody AuctionDto auctionDto) {
        Auction auction = auctionService.findById(id);
        auctionDto.setAuctionId(auction.getAuctionId());
        auctionService.saveAuctionDto(auctionDto);
        return new ResponseEntity<>("update", HttpStatus.OK);
    }

    @GetMapping("/auction/{id}")
    public ResponseEntity<AuctionDto> findByIdDto(@PathVariable Integer id) {
        return new ResponseEntity<>(auctionService.findByIdDto(id), HttpStatus.OK);
    }

    // Chau comment phan quyen vi dang bi loi phan quyen
    @GetMapping("/getAllStatusAuction")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<StatusAuctionDto>> getAllStatusAuction(){
        return new ResponseEntity<>(this.statusAuctionService.findAllStatusAuctionDto(), HttpStatus.OK);
    }

}
