package com.example.sprint2be.model.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "image")
public class ImageProduct {
    @Id
    private Integer imageId;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;
}
