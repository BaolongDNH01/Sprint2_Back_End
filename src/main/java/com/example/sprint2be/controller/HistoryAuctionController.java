package com.example.sprint2be.controller;

import com.example.sprint2be.model.HistoryAuction;
import com.example.sprint2be.service.HistoryAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/historyAuction")
public class HistoryAuctionController {

    @Autowired
    private HistoryAuctionService historyAuctionService;

    @GetMapping("")
    public List<HistoryAuction> getAllHistoryAuction() {
        List<HistoryAuction> historyAuction;
        historyAuction = historyAuctionService.findAll();
        return historyAuction;
    }

}
