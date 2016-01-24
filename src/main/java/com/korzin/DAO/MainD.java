//package com.korzin.DAO;
//
//import com.korzin.objects.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import javax.persistence.Persistence;
//import org.hibernate.Query;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
//* Created by user on 07-Dec-15.
//*/
//public class MainD {
//    public List<Integer> getLint() {
//        return lint;
//    }
//
//    public void setLint(List<Integer> lint) {
//        this.lint = lint;
//    }
//
//
//    List<Integer> lint = new ArrayList<Integer>();
//
//    public static void main(String[] args) {
//
//        SessionFactoryFactory sessionFactoryFactory = Persistence.createSessionFactoryFactory("shop3");
//        SessionFactory sessionFactory = sessionFactoryFactory.createSessionFactory();
//        System.out.println("Created em");
//        Customer customer = (Customer) findById(sessionFactory, 1, Customer.class);
//        System.out.println("CHOOSED COSTOMER TOSTRING" + customer);
//        System.out.println("LAST RETURN USERNAME: " + loadUserByUsername(sessionFactory, customer.getUsername()).getUsername());
//        for(Product p: findAllProductByPattern(sessionFactory, "%name%")){
//            System.out.println(p.getId() + " by pattern " + p.getName());
//        }
//
//
//        System.out.println(findByEmail(sessionFactory, "email1@gmail.com").getCountry());
//        Groups groupsTest = (Groups) (findById(sessionFactory, 1, Groups.class));
//        System.out.println("----" + groupsTest.getName());
//        for(Product p: findByGroup(sessionFactory,(Groups) findById(sessionFactory,2, Groups.class))){
//            System.out.println(p.getName());
//        }
//        groupsTest.setName("groupTest");
//        sessionFactory.getTransaction().begin();
//        sessionFactory.merge(groupsTest);
//        sessionFactory.getTransaction().commit();
//        Product p1 = findByIdProduct(sessionFactory, 1);
//        System.out.println(p1.getName());
//        for(Photo f: findAllPhotoOfProduct(sessionFactory, p1)){
//            System.out.println(f.getFirst_photo() + " id:" + f.getId() );
//        }
//        for(Comment f: findAllCommentOfProduct(sessionFactory, p1)){
//            System.out.println(f.getComment_date() + " id:" + f.getId() );
//        }
//        MainD mainD = new MainD();
//        mainD.lint.add(1);
//        mainD.lint.add(2);
//        mainD.lint.add(3);
//        mainD.lint.add(4);
//        for(Integer i: mainD.lint){
//            System.out.println("lint " + i);
//        }
//        List<Integer> temp = mainD.getLint();
//        temp.add(5);
//        mainD.setLint(temp);
//        for(Integer i: mainD.lint){
//            System.out.println("lint " + i);
//        }
//        System.out.println("============== ");
//        Customer ccustomer = findByName(sessionFactory,"username1");
//        for(CustomerRole customerRole: ccustomer.getCustomerRole()){
//            System.out.println("getRole " + customerRole.getRole() + " getId " + customerRole.getId() + "getCustomerId" + customerRole.getCustomer().getId());
//        }
//    }
//
//    public static UserDetails loadUserByUsername(SessionFactory sessionFactory, final String username) throws UsernameNotFoundException {
//        System.out.println("In loadUserByUsername");
//        Customer customer = findByName(sessionFactory, username);
//        System.out.println(" cust0mer.getUsername in loadUserByUsername " + customer.getUsername());
//        List<GrantedAuthority> authorities = buildUserAuthority( sessionFactory, customer.getCustomerRole());
//        System.out.println("PRINT List<GrantedAuthority> authorities = buildUserAuthority(customer.getCustomerRole());");
//        for(GrantedAuthority grantedAuthority: authorities){
//            System.out.println(grantedAuthority.getAuthority().toString());
//        }
//        return buildUserForAuthentication(customer, authorities);
//
//    }
//
//    // Converts com.korzin.users.model.User user to
//    // org.springframework.security.core.userdetails.User
//    private static User buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
//        System.out.println("In  buildUserForAuthentication");
//        for(GrantedAuthority ga: authorities){
//            System.out.println("ga.getAuthority().toString()" + ga.getAuthority());
//        }
//        System.out.println("customer.getUsername() " +customer.getUsername()
//                + " customer.getPassword() "+customer.getPassword()+ " customer.isEnabled() " + customer.isEnabled());
//        System.out.println("PRINT CUSTOMER IN private User buildUserForAuthentication(..,..): id =" + customer.getId() + "username = " + customer.getUsername());
//        return new User(customer.getUsername(), customer.getPassword(), customer.isEnabled(), true, true, true, authorities);
//    }
//
//    private static List<GrantedAuthority> buildUserAuthority(SessionFactory sessionFactory, Set<CustomerRole> customerRoles) {
//        System.out.println("In  buildUserAuthority");
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        // Build user's authorities
//        for (CustomerRole userRole : customerRoles) {
//            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//            System.out.println("userRole from buildUserAuthority ->"
//                    + userRole.getRole() + " " + findById(sessionFactory, userRole.getId(), Customer.class).toString());
//        }
//
//        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return result;
//    }
//    public static Customer findByName(SessionFactory sessionFactory,String username)  {
//        Query query = sessionFactory.createQuery("select c from Customer c where c.username =:username").setParameter("username", username);
//        return (Customer) ResultUtil.result(query);
//    }
//    public static Groups findByIdGroup(SessionFactory sessionFactory, int id) {
//        Query query = sessionFactory.createQuery("select e from " + Groups.class.getName() + " e where e.id=:id").setParameter("id", id);
//        return (Groups) ResultUtil.result(query);
//    }
//    public static Product findByIdProduct(SessionFactory sessionFactory, int id) {
//        Query query = sessionFactory.createQuery("select e from " + Product.class.getName() + " e where e.id=:id").setParameter("id", id);
//        return (Product) ResultUtil.result(query);
//    }
//    public static Object findById(SessionFactory sessionFactory, int id, Class clazz){
//        Query query = sessionFactory.createQuery("select e from " + clazz.getName() + " e where e.id=:id").setParameter("id", id);
//        return ResultUtil.result(query);
//    }
//    public static List<Product> findByGroup(SessionFactory sessionFactory,Groups groups ){
//        Query query = sessionFactory.createQuery("select p from Product p where p.groups = :groups", Product.class).setParameter("groups",groups);
//        return ResultUtil.resultList(query);
//    }
//    public static Customer findByEmail(SessionFactory sessionFactory, String email)  {
//        Query query = sessionFactory.createQuery("select c from Customer c where c.email=:email").setParameter("email", email);
//        return (Customer) ResultUtil.result(query);
//    }
//    public static List<Photo> findAllPhotoOfProduct(SessionFactory sessionFactory, Product product){
//        Query query = sessionFactory.createQuery("select f from Photo f where f.product = :product", Photo.class).setParameter("product", product);
//        return ResultUtil.resultList(query);
//    }
//    public static List<Comment> findAllCommentOfProduct(SessionFactory sessionFactory, Product product){
//        Query query = sessionFactory.createQuery("select f from Comment f where f.product = :product", Comment.class).setParameter("product", product);
//        return ResultUtil.resultList(query);
//    }
//    public static Groups findGroupByName(SessionFactory sessionFactory, String name)  {
//        Query query = sessionFactory.createQuery("select g from Groups g where g.name =:name").setParameter("name", name);
//        return (Groups) ResultUtil.result(query);
//    }
//    public static List<Product> findAllProductByPattern(SessionFactory sessionFactory, String pattern) {
//        Query query = sessionFactory.createQuery("select c from Product c where c.name like :pattern ").setParameter("pattern", pattern);
//        return ResultUtil.resultList(query);
//    }
//}
