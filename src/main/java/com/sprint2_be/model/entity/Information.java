package com.sprint2_be.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@JsonIgnoreProperties
@Table(name = "information")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="full_name")
    private String fullName;

    @Column(name="email")
    private String email;

    @Column(name="birth")
    private Date birth;

    @Column(name="password_current")
    private String passwordCurrent;

    @Column(name="password_new")
    private String passwordNew;

    @Column(name="id_card")
    private String idCard;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="url")
    private String url;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    public Information() {
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", passwordCurrent='" + passwordCurrent + '\'' +
                ", passwordNew='" + passwordNew + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPasswordCurrent() {
        return passwordCurrent;
    }

    public void setPasswordCurrent(String passwordCurrent) {
        this.passwordCurrent = passwordCurrent;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
