package com.example.sprint2be.model.auction.dto;

import java.util.List;

public class AuctionDto {

    private Integer auctionId;
    private String dayTimeStart;
    private String dayTimeEnd;
    private Integer status_id;
    private Integer product_id;
    private List<Integer> bidderList_id;

    public AuctionDto() {

    }

    public AuctionDto(Integer auctionId, String dayTimeStart, String dayTimeEnd, Integer status_id,
                      Integer product_id, List<Integer> bidderList_id) {
        this.auctionId = auctionId;
        this.dayTimeStart = dayTimeStart;
        this.dayTimeEnd = dayTimeEnd;
        this.status_id = status_id;
        this.product_id = product_id;
        this.bidderList_id = bidderList_id;
    }

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

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public List<Integer> getBidderList_id() {
        return bidderList_id;
    }

    public void setBidderList_id(List<Integer> bidderList_id) {
        this.bidderList_id = bidderList_id;
    }
}
