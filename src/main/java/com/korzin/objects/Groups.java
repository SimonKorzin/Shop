package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
* Created by user on 28-Nov-15.
*/
@Entity
public class Groups {

    private int id;
    private String name;
    private String description;
    private String photo;


    private List<Product> products = new ArrayList<Product>();

    public Groups(String name, String description, String photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }
    public Groups(){}



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "groups_id")
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @OneToMany(mappedBy = "groups",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
