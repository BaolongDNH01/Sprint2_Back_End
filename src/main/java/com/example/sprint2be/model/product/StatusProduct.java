package com.example.sprint2be.model.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="StatusProduct")
public class StatusProduct {
    @Id
    private Integer statusId;
    private String statusName;

    @OneToMany(mappedBy = "statusProduct", cascade = CascadeType.DETACH)
    private List<Product> productList;

    public StatusProduct() {
    }

    public StatusProduct(Integer statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
