package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
* Created by user on 28-Nov-15.
*/
@Entity
public class Product {


    private int id;
    private String name;
    private String description;
    private String short_description;
    private float price;

    private Groups groups;
    private String code;

    private List<Photo> photos = new ArrayList<Photo>();

    private List<Comment> comments = new ArrayList<Comment>();

    private List<Orders> orderses = new ArrayList<Orders>();
    public Product(){}

    public Product(String name, String description, String short_description, float price, Groups groups, String code) {
        this.name = name;
        this.description = description;
        this.short_description = short_description;
        this.price = price;
        this.groups = groups;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "product")
    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "product")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }
}