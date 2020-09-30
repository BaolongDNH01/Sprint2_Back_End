package com.sprint2_be.controller;

import com.sprint2_be.model.entity.Information;
import com.sprint2_be.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("")
    public List<Information> getAllInformation() {
        List<Information> information;
        information = informationService.findAll();
        return information;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Information> getInformation(@PathVariable("id") int id) {
        Information information = informationService.findById(id);
        if (information != null) {
            return ResponseEntity.ok(information);
        }
        return null;
    }


}
