package com.korzin.services;

import com.korzin.DAO.Interf.CustomerDao;
import com.korzin.DAO.Interf.OrdersDao;
import com.korzin.objects.Customer;
import com.korzin.objects.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public class OrdersService {
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    CustomerDao customerDao;

    public void add(Timestamp order_date, int customer_id){
        Orders orders = new Orders(order_date);
        Customer customer = customerDao.findById(customer_id);
        customer.getOrderses().add(orders);
    }
    public Orders findById(int id){
        return ordersDao.findById(id);
    }

    public List<Orders> findAll(){
       return ordersDao.findAll();
    }
}
