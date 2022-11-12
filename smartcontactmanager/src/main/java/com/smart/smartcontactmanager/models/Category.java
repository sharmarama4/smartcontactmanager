package com.smart.smartcontactmanager.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


@Entity
@Table(name = "categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "category_name")
    private  String categoryName;

    private  String description;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product>products=new ArrayList<>();
    public List<Product> getProducts(Category category) {
        return category.products;
    }

    public void setCategory(List<Product> products) {
        this.products = products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName(Category category) {
        return category.categoryName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
