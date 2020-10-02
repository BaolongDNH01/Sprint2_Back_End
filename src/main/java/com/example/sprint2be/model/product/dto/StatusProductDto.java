package com.example.sprint2be.model.product.dto;

import java.util.List;

public class StatusProductDto {
    private Integer statusId;
    private String statusName;
    private List<Integer> productList_Id;

    public StatusProductDto() {
    }

    public StatusProductDto(Integer statusId, String statusName, List<Integer> productList_Id) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.productList_Id = productList_Id;
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

    public List<Integer> getProductList_Id() {
        return productList_Id;
    }

    public void setProductList_Id(List<Integer> productList_Id) {
        this.productList_Id = productList_Id;
    }
}
