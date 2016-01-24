package com.korzin.DAO.Impl;


import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.PhotoDao;
import com.korzin.objects.Photo;

/**
* Created by user on 29-Nov-15.
*/
public class PhotoDaoImpl extends DaoImpl<Photo> implements PhotoDao {
    public PhotoDaoImpl(){
        super(Photo.class);
    }

}
