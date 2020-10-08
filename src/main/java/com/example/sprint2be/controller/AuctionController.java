package com.example.sprint2be.controller;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.BidderDto;
import com.example.sprint2be.service.auction.AuctionService;
import com.example.sprint2be.service.auction.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class AuctionController {
    @Autowired
    AuctionService auctionService;

    @Autowired
    BidderService bidderService;

    @PostMapping("/create-auction")
    public ResponseEntity<Auction> createProduct(@RequestBody Auction auction, UriComponentsBuilder builder) {
        auctionService.save(auction);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-auction/{id}").buildAndExpand(auction.getAuctionId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-bidder-auction/{id}")
    public ResponseEntity<List<Bidder>> getListBidder(@PathVariable("id") Integer id) {
        List<Bidder> bidders = bidderService.findBidderByAuction(id);
        return new ResponseEntity<>(bidders, HttpStatus.OK);
    }








    @PostMapping("/create-bidder")
    public ResponseEntity<Bidder> createBidder(@RequestBody BidderDto bidder, UriComponentsBuilder builder) {
        bidderService.saveDto(bidder);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-bidder/{id}").buildAndExpand(bidder.getBidId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
