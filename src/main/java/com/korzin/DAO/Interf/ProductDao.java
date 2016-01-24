package com.korzin.DAO.Interf;


import com.korzin.DAO.Dao;
import com.korzin.objects.Comment;
import com.korzin.objects.Groups;
import com.korzin.objects.Photo;
import com.korzin.objects.Product;

import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public interface ProductDao extends Dao<Product> {
    public Product findByName(String name);
    public Product findByCode(String code);
    public List<Product> findAllProductByPattern(String pattern);
    public List<Product> findByLimits(double lowerBound, double upperBound);
    public List<Product> findByGroup(Groups groups);
    public List<Photo> findAllPhotoOfProduct(Product product);
    public List<Comment> findAllCommentOfProduct(Product product);
}
