package com.vivas.springmvc.base;

import com.google.common.collect.Lists;
import com.vivas.springmvc.persistences.entity.User;
import com.vivas.springmvc.utils.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
@Repository
public class BaseDAOImpl<T> implements BaseDAOInteface {
    @Autowired
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public String getSysDate(String pattern) throws Exception {
        String queryString = "SELECT to_char(sysdate,:id)  from dual";
        Query query = getSession().createSQLQuery(queryString);
        query.setParameter("id", pattern);
        return query.list().get(0).toString();

    }
    //crud
    @Transactional
    public String deleteById(long id,Class objectClass){
        T object = (T)getSession().get(objectClass,id);
        return deleteByObject(object);
    }

    @Transactional
    public String deleteByObject(T obj) {
        try {
            getSession().delete(obj);
            return Constants.RESULT.SUCCESS;
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.getMessage();
        }
    }

    @Transactional
    public String saveOrUpdate(T obj) {
        try {
            getSession().saveOrUpdate(obj);
            return Constants.RESULT.SUCCESS;
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.getMessage();
        }
    }@Transactional
    public String saveBySession(T obj,Session session) {
        try {
            long id = (long) session.save(obj);
            session.flush();
            return id+"";
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.getMessage();
        }
    }
    //
    //find
    @Transactional(readOnly = true)
    public T findById(long id,Class objectClass) {
        return (T)getSession().get(objectClass,id);

    }

    //TODO test
    @Transactional(readOnly = true)
    public List findAll(Class objectClass) {
        List lstUser = Lists.newArrayList();
        lstUser.add(new User("duyot","password in base dao"));
        return lstUser;
    }
}
