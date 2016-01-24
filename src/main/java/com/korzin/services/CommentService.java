package com.korzin.services;


import com.korzin.DAO.Interf.CommentDao;
import com.korzin.DAO.Interf.ProductDao;
import com.korzin.objects.Comment;
import com.korzin.objects.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
* Created by user on 29-Nov-15.
*/
//@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;
    @Autowired
    ProductDao productDao;
//    @Transactional

    public Comment findById(int id){return commentDao.findById(id);}
    public void delete(Integer id){commentDao.delete(id);}
    public void add( String name, String text, Date comment_date, int product_id) {
        Product product = productDao.findById(product_id);
        Comment comment = new Comment(name, text, comment_date, product);
        commentDao.add(comment);
    }
    public void add(Comment comment){
        commentDao.add(comment);
    }
//        Product product = productDao.findById(product_id);
//        System.err.println("PRODUCT BY ADD COMMENT" + product.getId());
//        product.getComments().add(comment);
//
//
//        productDao.add(product);
//        for(Comment c: productDao.findAllCommentOfProduct(product)){
//            System.err.println("After add to database " + c.getName());
//        }
}
