package com.example.sprint2be.controller;

import com.example.sprint2be.model.Rank;
import com.example.sprint2be.service.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RankResController {
    @Autowired
    RankService rankService;
    @GetMapping("/rank")
    public ResponseEntity<List<Rank>> getListRank(){
        return new ResponseEntity<>(rankService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/rank/{id}")
    public ResponseEntity<Rank> getRank(@PathVariable Integer id){
        return new ResponseEntity<>(rankService.findById(id), HttpStatus.OK);
    }
}
