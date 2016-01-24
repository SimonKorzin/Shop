package com.korzin.objects;//package com.korzin.com.korzin.objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Created by user on 28-Nov-15.
*/
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    private String username;
    private String password;
    private boolean enabled;
    private String first_name;
    private String last_name;
    private String email;
    private String customer_photo;
    private String country;
    private String city;
    private String street;
    private String house;
    private float amount;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerRole> customerRole = new HashSet<CustomerRole>(0);
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Orders> orderses = new ArrayList<Orders>();

    public Customer(String username, String password, boolean enabled, String first_name, String last_name, String email, String customer_photo, String country, String city, String street, String house, float amount) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.customer_photo = customer_photo;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.amount = amount;

    }

    public Customer(){}

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Customer(String username, String password, boolean enabled, Set<CustomerRole> customerRole) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.customerRole = customerRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<CustomerRole> getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(Set<CustomerRole> customerRole) {
        this.customerRole = customerRole;
    }

    public Customer(String first_name, String last_name, String email, String customer_photo, String country, String city, String street, String house, float amount) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.customer_photo = customer_photo;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomer_photo() {
        return customer_photo;
    }

    public void setCustomer_photo(String customer_photo) {
        this.customer_photo = customer_photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }

    public String toString(){
        return getUsername() + " " + getId();
    }
}
