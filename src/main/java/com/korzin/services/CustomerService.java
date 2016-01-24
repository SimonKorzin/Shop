package com.korzin.services;

import com.korzin.DAO.Interf.CustomerDao;
import com.korzin.objects.Customer;
import com.korzin.objects.CustomerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
* Created by user on 29-Nov-15.
*/
@Service("service")
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public void addOrUpdate(String first_name, String last_name, String email, String customer_photo, String country, String city, String street, String house, float amount){
        Customer customer = new Customer(first_name, last_name, email, customer_photo, country, city, street,city, amount);
        customerDao.add(customer);

    }
    public Customer findByUsername(String username){ return customerDao.findByName(username);}

    public void addOrUpdate(Customer customer){
        customerDao.add(customer);
    }

    public void findByEmail(String email){
        customerDao.findByEmail(email);
    }
    public void findAll(){
        customerDao.findAll();
    }
    public Customer findById(int id){
        return customerDao.findById(id);
    }
//    @Transactional
//    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        Customer customer = customerDao.findByName(username);
        System.out.println(customer.getUsername());
        List<GrantedAuthority> authorities = buildUserAuthority(customer.getCustomerRole());
        System.err.println("PRINT List<GrantedAuthority> authorities = buildUserAuthority(customer.getCustomerRole());");
        for(GrantedAuthority grantedAuthority: authorities){
            System.err.println(grantedAuthority.getAuthority().toString());
        }
        return buildUserForAuthentication(customer, authorities);

    }


    private User buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
        System.err.println("PRINT CUSTOMER IN private User buildUserForAuthentication(..,..): id =" + customer.getId() + "username = " + customer.getUsername());
        return new User(customer.getUsername(), customer.getPassword(), customer.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<CustomerRole> customerRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (CustomerRole userRole : customerRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

        return result;
    }

}
