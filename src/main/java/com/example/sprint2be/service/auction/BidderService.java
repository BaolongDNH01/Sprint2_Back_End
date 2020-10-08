package com.example.sprint2be.service.auction;

import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.auction.dto.BidderDto;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.product.AuctionTime;

import java.util.List;

public interface BidderService {
    List<Bidder> findAll();
    Bidder findById(Integer bidderId);
    void save(Bidder bidder);
    void delete(Integer bidderId);

    void saveDto(BidderDto bidderDto);

    //hiện thị danh sách người đấu thầu trong 1 phiên
    List<Bidder>findByAuction_AuctionId(Integer id);

//    khanh
    List<UserBidderDto> findAllBidderByU(String userName);
}
