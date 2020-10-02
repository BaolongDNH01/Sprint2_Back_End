package com.example.sprint2be.model.product;



import com.example.sprint2be.model.auction.Auction;
import com.example.sprint2be.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private Double initialPrice;
    private Double eachIncrease;
    private String image;
    private String productDetail;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "time_id")
    private AuctionTime auctionTime;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "status_id")
    private StatusProduct statusProduct;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user_product;

    @OneToMany(mappedBy = "product", cascade = CascadeType.DETACH)
    private List<Auction> auctionList;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public User getUser_product() {
        return user_product;
    }

    public void setUser_product(User user_product) {
        this.user_product = user_product;
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }
}
