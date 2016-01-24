package com.korzin.services;

import com.korzin.DAO.Interf.GroupsDao;
import com.korzin.DAO.Interf.PhotoDao;
import com.korzin.DAO.Interf.ProductDao;
import com.korzin.objects.Comment;
import com.korzin.objects.Groups;
import com.korzin.objects.Photo;
import com.korzin.objects.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public class ProductService {

    @Autowired
    GroupsDao groupsDao;
    @Autowired
    PhotoDao photoDao;
    @Autowired
    ProductDao productDao;

    public void add(String name, String description, String short_description, float price, Groups groups, String code, List<Photo> photos) {
        Product product = new Product(name, description, short_description, price, groups, code);
        for (Photo ph : photos) {
            ph.setProduct(product);
        }
        productDao.add(product);
    }
    public void add(Product product){
        productDao.add(product);
    }
    public List<Product> findAllProductByPattern(String pattern){
        return productDao.findAllProductByPattern(pattern);
    }

    public Product findById(int id){ return  productDao.findById(id); }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findByCode(String code) {
        return productDao.findByCode(code);
    }

    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    public void delete(Integer id) {
        productDao.delete(id);
    }

    public List<Product> findByGroup(Groups groups) {
       return productDao.findByGroup(groups);
    }

    public List<Photo> findAllPhotoOfProduct(Product product){return productDao.findAllPhotoOfProduct(product); }

    public List<Comment> findAllCommentOfProduct(Product product){ return productDao.findAllCommentOfProduct(product); }

    public List<Product> findByLimits( double lowerBound, double upperBound){ return productDao.findByLimits(lowerBound,upperBound);}
}