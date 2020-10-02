package com.example.sprint2be.model.auction.dto;

import java.util.List;

public class StatusAuctionDto {

    private Integer statusId;
    private String statusName;
    private List<Integer> auctionList_id;

    public StatusAuctionDto() {

    }

    public StatusAuctionDto(Integer statusId, String statusName, List<Integer> auctionList_id) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.auctionList_id = auctionList_id;
    }

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

    public List<Integer> getAuctionList_id() {
        return auctionList_id;
    }

    public void setAuctionList_id(List<Integer> auctionList_id) {
        this.auctionList_id = auctionList_id;
    }
}
