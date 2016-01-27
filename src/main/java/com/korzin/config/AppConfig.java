package com.korzin.config;

import com.korzin.DAO.Impl.*;
import com.korzin.DAO.Interf.*;
import com.korzin.services.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan({"com.korzin"})
//@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {


	@Bean
	public CommentDao commentDao(){
//        System.out.println("In comment dao");
		return new CommentDaoImpl();
	}
	@Bean
	public CommentService commentService(){
//        System.out.println("in comment service");
		return new CommentService();
	}//Comment
	@Bean
	public CustomerDao customerDao(){
		return new CustomerDaoImpl();
	}
	@Bean
	public CustomerService customerService(){
		return new CustomerService();
	}//Customer
	@Bean
	public GroupsDao groupsDao(){
		return new GroupsDaoImpl();
	}
	@Bean
	public GroupsService groupsService(){
		return new GroupsService();
	}//Groups
	@Bean
	public OrdersDao ordersDao(){
		return new OrdersDaoImpl();
	}
	@Bean
	public OrdersService ordersService(){
		return new OrdersService();
	}//Orders
	@Bean
	public PhotoDao photoDao(){
		return new PhotoDaoImpl();
	} //Photo - only PhotoDao
	@Bean
	public ProductDao productDao(){
		return new ProductDaoImpl();
	}
	@Bean
	public ProductService productService(){
		return new ProductService();
	}//Product
	@Bean
	public CustomerRoleDao customerRoleDao(){ return  new CustomerRoleDaoImpl();}//CustomerRole
	@Bean
	public CustomerRoleService customerRoleService(){ return new CustomerRoleService();}

//	@Bean
//	public EntityManager entityManager() {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop5");
//        System.out.println("In create em");
//		return emf.createEntityManager();
//	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
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
	
	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {
		
		BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/shop7");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

//	@Bean
//    public HibernateTransactionManager txManager() {
//        return new HibernateTransactionManager(sessionFactory());
//    }
		
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}