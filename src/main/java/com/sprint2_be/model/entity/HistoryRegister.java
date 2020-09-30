package com.sprint2_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties
@Table(name = "history_register")
public class HistoryRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register")
    private Integer id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_information")
    private String productInformation;

    @Column(name="registration_date")
    private Date registrationDate;

    @Column(name="status_register")
    private String statusRegister;

    @Column(name="cancel_register")
    private String cancelRegister;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    public HistoryRegister() {
    }

    @Override
    public String toString() {
        return "HistoryRegister{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productInformation='" + productInformation + '\'' +
                ", registrationDate=" + registrationDate +
                ", statusRegister='" + statusRegister + '\'' +
                ", cancelRegister='" + cancelRegister + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatusRegister() {
        return statusRegister;
    }

    public void setStatusRegister(String statusRegister) {
        this.statusRegister = statusRegister;
    }

    public String getCancelRegister() {
        return cancelRegister;
    }

    public void setCancelRegister(String cancelRegister) {
        this.cancelRegister = cancelRegister;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
