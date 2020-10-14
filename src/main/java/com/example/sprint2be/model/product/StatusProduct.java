package com.example.sprint2be.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="status_product")
public class StatusProduct {
    @Id
    private Integer statusId;
    private String statusName;

    @OneToMany(mappedBy = "statusProduct", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<Product> productList;

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
