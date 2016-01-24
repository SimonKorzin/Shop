package com.korzin.DAO.Impl;


import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.CustomerDao;
import com.korzin.DAO.ResultUtil;
import com.korzin.objects.Customer;
import org.hibernate.Query;
import org.hibernate.Session;


/**
* Created by user on 29-Nov-15.
*/
public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDao {
    public CustomerDaoImpl(){
        super(Customer.class);
    }


    @Override
    public Customer findByEmail(String email)  {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select c from Customer c where c.email=:email").setParameter("email", email);
        session.getTransaction().commit();
        session.close();
        return (Customer) ResultUtil.result(query);
    }

    @Override
    public Customer findByName(String username)  {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Query query = session.createQuery("select c from Customer c where c.username =:username").setParameter("username", username);
            session.getTransaction().commit();

            return (Customer) ResultUtil.result(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }

}
