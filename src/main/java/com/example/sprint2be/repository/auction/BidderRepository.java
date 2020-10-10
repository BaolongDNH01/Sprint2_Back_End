package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidderRepository extends JpaRepository<Bidder,Integer> {

    //hiện thị danh sách người đấu thầu trong 1 phiên
    List<Bidder> findBiddersByAuction(Auction auction);

//    khanh
    List<Bidder> findBiddersByUserBidder(User user);
}
