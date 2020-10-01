package com.example.sprint2be.model.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="AuctionTime")
public class AuctionTime {
    @Id
    private Integer timeId;
    private Integer auctionTime;

    @OneToMany(mappedBy = "auctionTime", cascade = CascadeType.DETACH)
    private List<Product> productList;

    public AuctionTime() {
    }

    public AuctionTime(Integer timeId, Integer auctionTime) {
        this.timeId = timeId;
        this.auctionTime = auctionTime;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Integer getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Integer auctionTime) {
        this.auctionTime = auctionTime;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
