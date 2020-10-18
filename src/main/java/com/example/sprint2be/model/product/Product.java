package com.example.sprint2be.model.product;



import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="product")
public class Product implements Serializable {
    @Id
    private Integer productId;
    private String productName;
    private Double initialPrice;
    private Double eachIncrease;
    private String productDetail;
    private String datePost;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "time_id")
    @JsonManagedReference
    private AuctionTime auctionTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "status_id")
    private StatusProduct statusProduct;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<Auction> auctionList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.DETACH)
    private List<ImageProduct> imageProductList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Double getEachIncrease() {
        return eachIncrease;
    }

    public void setEachIncrease(Double eachIncrease) {
        this.eachIncrease = eachIncrease;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AuctionTime getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(AuctionTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProduct statusProduct) {
        this.statusProduct = statusProduct;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }

    public List<ImageProduct> getImageProductList() {
        return imageProductList;
    }

    public void setImageProductList(List<ImageProduct> imageProductList) {
        this.imageProductList = imageProductList;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }
}
