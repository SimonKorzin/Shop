package com.korzin.DAO;

import org.hibernate.Query;
import java.util.List;


public class ResultUtil {

    @SuppressWarnings("unchecked")
    public static <T> List<T> resultList(Query query) {
        return (List<T>) query.list();
    }

    @SuppressWarnings("unchecked")
    public static <T> T result(Query query)  {
            return (T) query.list().get(0);
    }
}