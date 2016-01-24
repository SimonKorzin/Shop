package com.korzin.services;

import com.korzin.DAO.Interf.CustomerRoleDao;
import com.korzin.objects.CustomerRole;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 21-Jan-16.
 */
public class CustomerRoleService {
    @Autowired
    public CustomerRoleDao customerRoleDaoImpl;

    public void add(CustomerRole customerRole){
        customerRoleDaoImpl.add(customerRole);
    }
}
