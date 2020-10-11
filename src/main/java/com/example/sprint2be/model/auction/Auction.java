package com.example.sprint2be.model.auction;



import com.example.sprint2be.model.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auctionId;
    private String dayTimeStart;
    private String dayTimeEnd;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "status_id")
    private StatusAuction statusAuction;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.DETACH)
    private List<Bidder> bidderList;

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getDayTimeStart() {
        return dayTimeStart;
    }

    public void setDayTimeStart(String dayTimeStart) {
        this.dayTimeStart = dayTimeStart;
    }

    public String getDayTimeEnd() {
        return dayTimeEnd;
    }

    public void setDayTimeEnd(String dayTimeEnd) {
        this.dayTimeEnd = dayTimeEnd;
    }

    public StatusAuction getStatusAuction() {
        return statusAuction;
    }

    public void setStatusAuction(StatusAuction statusAuction) {
        this.statusAuction = statusAuction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Bidder> getBidderList() {
        return bidderList;
    }

    public void setBidderList(List<Bidder> bidderList) {
        this.bidderList = bidderList;
    }
}
