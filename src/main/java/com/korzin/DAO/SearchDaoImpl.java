package com.korzin.DAO;

import com.korzin.objects.Groups;
import com.korzin.objects.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by samual on 27.01.16.
*/
public class SearchDaoImpl {

    @Autowired
    protected SessionFactory sessionFactory;

    public List<Product> doSearch(Groups groups, String productName, String productCode, double lowerBound, double upperBound){
        String queryString  = "select p from Product p where ";
        if(groups != null) {
            queryString.concat("  p.groups = :groups");
        }
        Session session = sessionFactory.openSession();

        try{
            session.getTransaction().begin();
            String str = "select p from Product p where p.name =:name";
            org.hibernate.Query query = session.createQuery("select p from Product p where p.name =:name").setParameter("name", name);
            session.getTransaction().commit();
            return ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
        }
    }
}
