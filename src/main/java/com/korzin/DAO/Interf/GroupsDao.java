package com.korzin.DAO.Interf;


import com.korzin.DAO.Dao;
import com.korzin.objects.Groups;

/**
* Created by user on 29-Nov-15.
*/
public interface GroupsDao extends Dao<Groups> {
    public Groups findByName(String name);
}
