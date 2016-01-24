package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;

/**
* Created by user on 28-Nov-15.
*/
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private int id;

    private String first_photo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Product product;

//    public boolean isMain() {
//        return isMain;
//    }
//
//    public void setMain(boolean isMain) {
//        this.isMain = isMain;
//    }
//
//    private boolean isMain;
    public Photo(){}
    public Photo(String first_photo, Product product) {
        this.first_photo = first_photo;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_photo() {
        return first_photo;
    }

    public void setFirst_photo(String first_photo) {
        this.first_photo = first_photo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
