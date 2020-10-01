package com.example.sprint2be.model.auction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class StatusAuction {
    @Id
    private Integer statusId;
    private String statusName;

    @OneToMany(mappedBy = "statusAuction", cascade = CascadeType.DETACH)
    private List<Auction> auctionList;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Auction> getProductList() {
        return auctionList;
    }

    public void setProductList(List<Auction> productList) {
        this.auctionList = productList;
    }
}
