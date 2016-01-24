package com.korzin.DAO.Impl;

import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.CustomerRoleDao;
import com.korzin.objects.CustomerRole;

/**
 * Created by user on 21-Jan-16.
 */
public class CustomerRoleDaoImpl extends DaoImpl<CustomerRole> implements CustomerRoleDao {
    public CustomerRoleDaoImpl() {
        super(CustomerRole.class);
    }
}
