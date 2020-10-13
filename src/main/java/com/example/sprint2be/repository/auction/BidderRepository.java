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
            value = "select product.product_id ,bidder.user_id,max(bid_price) as winPrice from bidder join auction" +
                    " on auction.auction_id=bidder.auction_id right join product on product.product_id=auction.auction_id" +
                    " where product.status_id=3 group by(auction.auction_id) having user_id=?1", nativeQuery = true)
    List getCartByIdUser(Integer userId);
}
