package com.example.sprint2be.model.auction;


import com.example.sprint2be.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "bidder")
public class Bidder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Integer bidId;

    private Double bidPrice;
    private String bidDateTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    private User userBidder;


    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidDateTime() {
        return bidDateTime;
    }

    public void setBidDateTime(String bidDateTime) {
        this.bidDateTime = bidDateTime;
    }


    public Auction getAuction_bidder() {
        return this.auction;
    }

    public void setAuction_bidder(Auction auction_bidder) {
        this.auction = auction_bidder;
    }

    public User getUser_bidder() {
        return userBidder;
    }

    public void setUser_bidder(User user_bidder) {
        this.userBidder = user_bidder;
    }
}



