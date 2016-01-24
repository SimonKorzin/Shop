package com.korzin.DAO.Impl;


import com.korzin.DAO.DaoImpl;
import com.korzin.DAO.Interf.GroupsDao;
import com.korzin.DAO.ResultUtil;
import com.korzin.objects.Groups;
import org.hibernate.Session;


/**
* Created by user on 29-Nov-15.
*/
public class GroupsDaoImpl extends DaoImpl<Groups> implements GroupsDao {

    public GroupsDaoImpl(){
        super(Groups.class);
    }


    @Override
    public Groups findByName(String name)  {
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            org.hibernate.Query query = session.createQuery("select p from Groups p where p.name =:name").setParameter("name", name);
            session.getTransaction().commit();

            return (Groups) ResultUtil.resultList(query);
        }catch (Exception e){
            return  null;
        }finally {
            session.close();
        }
    }

}
