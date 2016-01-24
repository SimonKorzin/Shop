package com.korzin.DAO;


import java.util.List;

/**
* Created by user on 29-Nov-15.
*/
public interface Dao<E> {

    List<E> findAll();
    public void delete(Integer id);
    void add(E entity);
    @SuppressWarnings("unchecked")
    E findById(int id);
    public Long count();

}
