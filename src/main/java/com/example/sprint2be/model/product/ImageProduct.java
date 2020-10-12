package com.example.sprint2be.model.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "image")
public class ImageProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer imageId;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
