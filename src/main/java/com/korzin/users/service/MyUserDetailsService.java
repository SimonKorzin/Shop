package com.korzin.users.service;

import com.korzin.objects.Customer;
import com.korzin.objects.CustomerRole;
import com.korzin.users.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

//	@Transactional(readOnly=true)
  	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		System.out.println("In  loadUserByUsername");
		Customer user = userDao.findByUserName(username);
		System.out.println("user.getFirst_name(): " + user.getFirst_name());
		List<GrantedAuthority> authorities = buildUserAuthority(user.getCustomerRole());
		System.err.println("PRINT List<GrantedAuthority> authorities = buildUserAuthority(customer.getCustomerRole());");
		for(GrantedAuthority grantedAuthority: authorities){
			System.err.println("grand" + grantedAuthority.getAuthority().toString());
		}
		UserDetails ud = buildUserForAuthentication(user, authorities);
		System.out.println("THIS IS COMPLITE USER DETAILS!");
		System.out.println("getUsername: " + ud.getUsername());
		System.out.println("getPassword: " + ud.getPassword());
		System.out.println("isEnabled: " + ud.isEnabled());
		System.out.println("AND COLLECTION ROLES");
		for(GrantedAuthority u: ud.getAuthorities()){
			System.out.println(u.getAuthority());
		}
		return ud;
		
	}

	// Converts com.korzin.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Customer user, List<GrantedAuthority> authorities) {
		System.out.println("In buildUserForAuthentication");
		System.err.println("PRINT CUSTOMER IN private User buildUserForAuthentication(..,..): id =" + user.getId() + "username = " + user.getUsername());
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<CustomerRole> userRoles) {
		System.out.println("In buildUserAuthority");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (CustomerRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			System.out.println("userRole id: " + userRole.getId() + " userRole.getCustomer: "  + userRole.getCustomer().getUsername());

		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}