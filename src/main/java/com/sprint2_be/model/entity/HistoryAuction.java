package com.sprint2_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties
@Table(name = "history_auction")
public class HistoryAuction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auction")
    private Integer id;

    @Column(name="order_number")
    private String orderNumber;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_information")
    private String productInformation;

    @Column(name="registration_price")
    private String registrationPrice;

    @Column(name="registration_date")
    private Date registrationDate;

    @Column(name="status_auction")
    private String statusAuction;

    @Column(name="cancel_auction")
    private String cancelAuction;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Override
    public String toString() {
        return "HistoryAuction{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", productInformation='" + productInformation + '\'' +
                ", registrationPrice='" + registrationPrice + '\'' +
                ", registrationDate=" + registrationDate +
                ", statusAuction='" + statusAuction + '\'' +
                ", cancelAuction='" + cancelAuction + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public String getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(String registrationPrice) {
        this.registrationPrice = registrationPrice;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatusAuction() {
        return statusAuction;
    }

    public void setStatusAuction(String statusAuction) {
        this.statusAuction = statusAuction;
    }

    public String getCancelAuction() {
        return cancelAuction;
    }

    public void setCancelAuction(String cancelAuction) {
        this.cancelAuction = cancelAuction;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
