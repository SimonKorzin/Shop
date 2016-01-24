package com.korzin.DAO.Impl;


import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.ProductDao;
import com.korzin.DAO.ResultUtil;
import com.korzin.objects.Comment;
import com.korzin.objects.Groups;
import com.korzin.objects.Photo;
import com.korzin.objects.Product;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public class ProductDaoImpl extends DaoImpl<Product> implements ProductDao {
    public ProductDaoImpl(){
        super(Product.class);
    }


//    @Autowired
//    EntityManager entityManager;
    @Override
    public Product findByName(String name)  {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Query query = session.createQuery("select p from Product p where p.name =:name").setParameter("name", name);
            session.getTransaction().commit();
            return (Product) ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }
    public List<Product> findByLimits(double lowerBound, double upperBound){
        Session session = sessionFactory.openSession();
        System.out.println("In findByLimits lowerBound = " + lowerBound);
        System.out.println("In findByLimits upperBound = " + upperBound);
        try{
            session.getTransaction().begin();
            Query query = session.createQuery("select p from Product p where p.price > 30.0 OR p.price < 1000.0");
//                    .setParameter("lowerBoundPar", lowerBound).setParameter("upperBoundPar", upperBound);
            System.out.println("-!!!!!!!!!!!!!!!!!!");
            for(Product p: (List<Product>) query.list()) {
                System.out.print( " " + p.getName());
            }
            return ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }
    @Override
    public Product findByCode(String code) {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Query query = session.createQuery("select p from Product p where p.code =:code").setParameter("code", code);
            session.getTransaction().commit();

            return (Product) ResultUtil.result(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }
    @Override
    public List<Product> findAllProductByPattern(String pattern) {
        Session session = sessionFactory.openSession();
        try{
               session.getTransaction().begin();
               Query query = session.createQuery("select c from Product c where c.name like :pattern").setParameter("pattern", "%" + pattern + "%");
               session.getTransaction().commit();
               return ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Product> findByGroup(Groups groups ){
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
           Query query = session.createQuery("select p from Product p where p.groups = :groups").setParameter("groups",groups);
           session.getTransaction().commit();

           return ResultUtil.resultList(query);
    }catch (Exception e){
        return  null;
    }finally {
        session.close();
    }
    }
    public List<Photo> findAllPhotoOfProduct(Product product){
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            Query query = session.createQuery("select f from Photo f where f.product = :product").setParameter("product", product);
            session.getTransaction().commit();
            return ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }
    public List<Comment> findAllCommentOfProduct(Product product){
            Session session = sessionFactory.openSession();
            try{
                session.getTransaction().begin();
                Query query = session.createQuery("select f from Comment f where f.product = :product").setParameter("product", product);
                session.getTransaction().commit();

                return ResultUtil.resultList(query);
            }catch (Exception e){
                return  null;
            }finally {
                session.close();
            }
    }
}