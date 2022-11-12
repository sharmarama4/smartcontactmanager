package com.smart.smartcontactmanager.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    private  String productName;
    private String image;
    private  double price;

    private  String productDescription;


    // Many to one relationship
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)

    private Category category;

    public Product() {
    }

    public Product( String productName,  Category category) {

        this.productName = productName;

        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
       this.productDescription = productDescription;
    }

    public Category getCategory(Category category) {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", category=" + category +
                '}';
    }


}
