package com.korzin.DAO.Impl;

import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.CommentDao;
import com.korzin.objects.Comment;

/**
* Created by user on 29-Nov-15.
*/
public class CommentDaoImpl extends DaoImpl<Comment> implements CommentDao {

    public CommentDaoImpl(){
        super(Comment.class);
    }

}
