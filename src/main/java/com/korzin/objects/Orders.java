package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* Created by user on 28-Nov-15.
*/
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Orders(Customer customer, Timestamp order_date) {
        this.customer = customer;
        this.order_date = order_date;
    }

    public Orders(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Timestamp order_date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "OrderProduct", catalog = "shop5",
            joinColumns = {@JoinColumn(name = "order_id",   referencedColumnName = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")} )
    private List<Product> products = new ArrayList<Product>();
    public Orders(){}
    public Orders( Timestamp order_date, List<Product> products) {

        this.order_date = order_date;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> Products) {
        this.products = Products;
    }
}
