package com.korzin.users.dao;

//import com.korzin.users.model.User;
import com.korzin.objects.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Customer findByUserName(String username) {
		System.out.println("In findByUserName");
		List<Customer> users = new ArrayList<Customer>();

		users = sessionFactory.openSession().createQuery("from Customer where username=?").setParameter(0, username)
				.list();
		for(Customer c: users){
			System.out.println("findByUserName:" + username + "values : " + c.getFirst_name() + " " + c.getPassword());
		}
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public Customer findByUserId(int id){
		List<Customer> users = new ArrayList<Customer>();

		users = sessionFactory.getCurrentSession().createQuery("from Customer where id=?").setParameter(0, id)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}