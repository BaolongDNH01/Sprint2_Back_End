package com.example.sprint2be.model.auction;


import javax.persistence.*;

@Entity
@Table(name = "bidder")
public class Bidder {
    @Id
    private Integer bidId;

    private Double bidPrice;
    private String bidDateTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "auction_id")
    private Auction auction_bidder;
//
//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "user_id")
//    private User user_bidder;


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
        return auction_bidder;
    }

    public void setAuction_bidder(Auction auction_bidder) {
        this.auction_bidder = auction_bidder;
    }



}



