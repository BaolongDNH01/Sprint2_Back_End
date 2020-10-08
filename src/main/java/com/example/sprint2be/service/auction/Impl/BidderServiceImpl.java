package com.example.sprint2be.service.auction.Impl;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.BidderDto;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.auction.AuctionRepository;
import com.example.sprint2be.repository.auction.BidderRepository;
import com.example.sprint2be.service.auction.BidderService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidderServiceImpl implements BidderService {
    @Autowired
    BidderRepository bidderRepository;
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    UserRepository userRepository;
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
    public void saveDto(BidderDto bidderDto) {
        Bidder bidder=new Bidder();
        bidder.setBidId(bidderDto.getBidId());
        bidder.setBidDateTime(bidderDto.getBidDateTime());
        bidder.setBidPrice(bidderDto.getBidPrice());
        bidder.setAuction_bidder(auctionRepository.findById(bidderDto.getAuctionId()).orElse(null));
        bidder.setUser_bidder(userRepository.findById(bidderDto.getUserId()).orElse(null));
        bidderRepository.save(bidder);
    }

    @Override
    public List<Bidder> findByAuction_AuctionId(Integer id) {
        return bidderRepository.findByAuction_AuctionId(id);
    }

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
