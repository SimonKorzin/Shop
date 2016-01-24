package com.korzin.objects;

/**
 * Created by customer on 13-Dec-15.
 */
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customer_role", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "customer_id" }))
public class CustomerRole {

    private int id;
    private Customer customer;

    private String role;

    public CustomerRole() {
    }

    public CustomerRole(Customer customer, String role) {
        this.customer = customer;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "customer_role_id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "role", nullable = false, length = 45)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

