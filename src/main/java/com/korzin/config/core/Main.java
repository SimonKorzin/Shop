package com.korzin.config.core;

import com.korzin.DAO.Impl.CustomerRoleDaoImpl;
import com.korzin.objects.Customer;
import com.korzin.objects.CustomerRole;
import com.korzin.objects.Product;
import com.korzin.users.dao.UserDaoImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.List;
import java.util.Properties;

/**
 * Created by user on 17-Dec-15.
 */
public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        CustomerRoleDaoImpl customerRoleDaoImpl = new CustomerRoleDaoImpl();
        Main main = new Main();
        SessionFactory sf = main.sessionFactory();
        Session session = sf.openSession();
        List<Customer> listCus =  session.createQuery("from Customer where username=?").setParameter(0, "username5").list();
        List<Product> listP = session.createQuery("select p from Product p where p.price > 0.5 AND p.price < 30.0").list();
        CustomerRole customerRole = new CustomerRole(listCus.get(0),"ROLE_USER");
        System.out.println("CUSTOMERROLE: " + customerRole.getRole() + " udername cus: " + customerRole.getCustomer().getUsername());
//        customerRoleImpl.add(customerRole);
        System.out.println("list od Product");
        for (Product p: listP){
            System.out.print(" " + p.getName());
        }
        System.out.println("list of Customer" + listCus.get(0).getUsername());
        for(Customer c: listCus){
            System.out.println(c.getFirst_name());
        }
    }
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder
                .scanPackages("com.korzin.objects")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }
    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        prop.put("hibernate.hbm2ddl.auto","update");
        return prop;
    }


    public BasicDataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/shop7");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
