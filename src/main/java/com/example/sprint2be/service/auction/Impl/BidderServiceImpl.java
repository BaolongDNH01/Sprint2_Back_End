package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.auction.BidderRepository;
import com.example.sprint2be.service.auction.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidderServiceImpl implements BidderService {
    @Autowired
    BidderRepository bidderRepository;
    @Override
    public List<Bidder> findAll() {
        return bidderRepository.findAll();
    }

    @Override
    public Bidder findById(Integer bidderId) {
        return bidderRepository.findById(bidderId).orElse(null);
    }

    @Override
    public void save(Bidder bidder) {
        bidderRepository.save(bidder);
    }

    @Override
    public void delete(Integer bidderId) {
        bidderRepository.deleteById(bidderId);
    }

    @Override
    public List<Bidder> findByAuction_AuctionId(Integer id) {
        return bidderRepository.findByAuction_AuctionId(id);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public List<UserBidderDto> findAllBidderByU(String userName) {
        User user =  userRepository.findByUsername(userName).orElse(new User());
        return bidderRepository.findBiddersByUserBidder(user).stream().map(this::convertToUserBidderDto).collect(Collectors.toList());
    }

    private UserBidderDto convertToUserBidderDto(Bidder bidder){
      UserBidderDto userBidderDto = new UserBidderDto();

      Auction auction = auctionRepository.findAuctionByBidderListContaining(bidder);
      userBidderDto.setProductName(auction.getProduct().getProductName());

      userBidderDto.setAuctionStatus(auction.getStatusAuction().getStatusName());
      userBidderDto.setDateBidder(bidder.getBidDateTime());
      userBidderDto.setPriceBidder(bidder.getBidPrice());
      userBidderDto.setProductId(auction.getProduct().getProductId());
      userBidderDto.setProductDetail(auction.getProduct().getProductDetail());
      return userBidderDto;
    }
}
