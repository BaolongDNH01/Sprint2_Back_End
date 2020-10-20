package com.example.sprint2be.repository.auction;

import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.auction.Bidder;
import com.example.sprint2be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BidderRepository extends JpaRepository<Bidder, Integer> {

    //hiện thị danh sách người đấu thầu trong 1 phiên
    List<Bidder> findBiddersByAuction(Auction auction);

    //    khanh
    List<Bidder> findBiddersByUserBidder(User user);


    //Chau
    @Query(
            value = "select product.product_id ,bidder.user_id,max(bid_price) as winPrice from bidder join auction" +
                    " on auction.auction_id=bidder.auction_id right join product on product.product_id=auction.auction_id" +
                    " where product.status_id=3 group by(auction.auction_id)", nativeQuery = true)
    List getAllCart();

    //hiện thị danh sách người đấu thầu trong 1 phiên có sắp xếp
    List<Bidder> findBiddersByAuctionOrderByBidPriceDesc(Auction auction);
    //kiểm tra đã đấu giá trong phiên
    Bidder findBidderByAuction_AuctionIdAndUserBidder_Username(Integer idAuction,String nameBidder);

    @Query(
            value = "select max(bid_price) from bidder where auction_id=?1", nativeQuery = true)
    Integer getMaxBidderByAuctionId(Integer auctionId);

    @Query(
            value = "select bidder.user_id, bidder.bid_price" +
                    " from bidder" +
                    " join auction on auction.auction_id=bidder.auction_id" +
                    " where auction.auction_id=?1" +
                    " group by bidder.auction_id, bidder.user_id" +
                    " having bidder.bid_price in (" +
                    "select max(bidder.bid_price) as max_price" +
                    " from bidder" +
                    " join auction on auction.auction_id=bidder.auction_id" +
                    " where auction.status_id=3" +
                    " group by bidder.auction_id" +
                    ")", nativeQuery = true
    )
    Integer getUserWinByAuctionId(Integer auctionId);
}
