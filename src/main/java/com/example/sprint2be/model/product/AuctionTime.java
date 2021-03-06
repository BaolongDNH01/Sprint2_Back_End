package com.example.sprint2be.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="auction_time")
public class AuctionTime {
    @Id
    private Integer timeId;

    private Integer auctionTime;
    private String moTa;
    @JsonBackReference
    @OneToMany(mappedBy = "auctionTime", cascade = CascadeType.DETACH)
    private List<Product> productList;

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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
