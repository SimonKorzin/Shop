package com.korzin.services;

import com.korzin.DAO.Interf.GroupsDao;
import com.korzin.objects.Groups;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public class GroupsService {

    @Autowired
    GroupsDao groupsDao;

    public Groups findById(int id){ return  groupsDao.findById(id);}
    public Groups findByName(String name){
       return  groupsDao.findByName(name);
    }
    public List<Groups> findAll(){ return groupsDao.findAll(); }
}
