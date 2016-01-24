package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;
import java.util.Date;

/**
* Created by user on 28-Nov-15.
*/
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    private String name;

    private String text;


    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;
//    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Product product;
    public Comment(){}


    public Comment(String name, String text, Date comment_date, Product product) {
        this.name = name;
        this.text = text;
        this.comment_date = comment_date;
        this.product = product;
    }

    public Comment(String name, String text, Date comment_date) {
        this.name = name;
        this.text = text;
        this.comment_date = comment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
    public Date getComment_date() {
        return comment_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
