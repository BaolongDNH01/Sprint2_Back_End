package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.StatusAuction;
import com.example.sprint2be.model.auction.dto.StatusAuctionDto;
import com.example.sprint2be.repository.auction.StatusAuctionRepository;
import com.example.sprint2be.service.auction.StatusAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusAuctionServiceImpl implements StatusAuctionService {
    @Autowired
    StatusAuctionRepository statusAuctionRepository;

    private StatusAuctionDto convertToStatusAuctionDto(StatusAuction statusAuction){
        StatusAuctionDto statusAuctionDto = new StatusAuctionDto();
        statusAuctionDto.setStatusId(statusAuction.getStatusId());
        statusAuctionDto.setStatusName(statusAuction.getStatusName());
        return statusAuctionDto;
    }

    @Override
    public List<StatusAuction> findAll() {
        return statusAuctionRepository.findAll();
    }

    @Override
    public StatusAuction findById(Integer statusAuctionId) {
        return statusAuctionRepository.findById(statusAuctionId).orElse(null);
    }

    @Override
    public void save(StatusAuction statusAuction) {
        statusAuctionRepository.save(statusAuction);
    }

    @Override
    public void delete(Integer statusAuctionId) {
        statusAuctionRepository.deleteById(statusAuctionId);
    }

    @Override
    public List<StatusAuctionDto> findAllStatusAuctionDto() {
        return (statusAuctionRepository.findAll().stream().map(this::convertToStatusAuctionDto).collect(Collectors.toList()));
    }
}
