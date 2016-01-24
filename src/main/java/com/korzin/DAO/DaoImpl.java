package com.korzin.DAO;

//import org.igorzadyra.exception.SingleResultNotFoundException;
//import org.igorzadyra.utils.ResultUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public abstract class DaoImpl<E> implements Dao<E> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<E> clazz;

    protected DaoImpl(Class<E> clazz) {
            this.clazz = clazz;
        }
//        @Transactional
    public void add(E entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
//       entityManager.getTransaction().begin();
//       entityManager.merge(entity);
//       entityManager.getTransaction().commit();
        }
    public void delete(Integer id){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        E product = (E) session.get(clazz, id);
        System.out.println("In delete():  = " + id + "Object is = " + clazz.getName());
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }
        public E findById(int id) {
            Session session = sessionFactory.openSession();
            try{
                session.getTransaction().begin();
                Query query = session.createQuery("select c from " + clazz.getName() + " c where c.id=:id").setParameter("id", id);
                session.getTransaction().commit();
               //
                System.out.println("RESULT OF SEARCHING BY ID : " + query.list().get(0));
                return (E) ResultUtil.result(query);
            }catch (Exception e){
            return  null;
            }finally {
            session.close();
            }
        }

        public Long count() {
            Session session = sessionFactory.openSession();
            try{
                session.getTransaction().begin();
                Query query = session.createQuery("select COUNT (e) from  " + clazz.getName() + " e");
                session.getTransaction().commit();
                return (Long) ResultUtil.result(query);
            }catch (Exception e){
                return  null;
            }finally {
                session.close();
            }
        }

        public List<E> findAll() {
            Session session = sessionFactory.openSession();
            try{

                session.getTransaction().begin();
                Query query = session.createQuery("select c from " + clazz.getName() + " c");
                session.getTransaction().commit();
                return ResultUtil.resultList(query);
            }catch (Exception e){
                return  null;
            }finally {
                session.close();
            }
        }




}

