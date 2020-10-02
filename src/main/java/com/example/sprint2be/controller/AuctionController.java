package com.example.sprint2be.controller;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.service.auction.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AuctionController {
    @Autowired
    AuctionService auctionService;
    @PostMapping("/create-auction")
    public ResponseEntity<Auction> createProduct(@RequestBody Auction auction, UriComponentsBuilder builder) {
        auctionService.save(auction);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get-auction/{id}").buildAndExpand(auction.getAuctionId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
