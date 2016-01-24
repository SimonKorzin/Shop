package com.korzin.users.dao;

import com.korzin.objects.Customer;

public interface UserDao {

	Customer findByUserName(String username);

}