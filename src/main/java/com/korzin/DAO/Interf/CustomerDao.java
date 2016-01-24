package com.korzin.DAO.Interf;

import com.korzin.DAO.Dao;
import com.korzin.objects.Customer;

/**
* Created by user on 29-Nov-15.
*/
public interface CustomerDao extends Dao<Customer> {

    public Customer findByEmail(String email) ;
    public  Customer findByName(String username);
}
