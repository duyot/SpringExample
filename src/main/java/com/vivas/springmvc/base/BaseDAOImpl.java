package com.vivas.springmvc.base;

import com.google.common.collect.Lists;
import com.vivas.springmvc.persistences.entity.User;
import com.vivas.springmvc.utils.Constants;
import com.vivas.springmvc.utils.DataUtil;
import com.vivas.springmvc.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
@Repository
//@org.hibernate.annotations.NamedQueries({
//        @NamedQuery(name = "findAll",query = "select * from AdminUser")
//})
public class BaseDAOImpl<T extends BaseModel,ID extends Serializable> implements BaseDAOInteface {
    @Autowired
    SessionFactory sessionFactory;

    private Class<T> modelClass;

    private Logger log = LoggerFactory.getLogger(BaseDAOImpl.class);

    public void setModelClass(Class modelClass){
        this.modelClass = modelClass;
    }

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
    public String deleteById(long id){
        T object = (T)getSession().get(modelClass,id);
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
    }

    @Transactional
    public String save(T obj) {
        try {
            long savedObjectId = (long) getSession().save(obj);
            return savedObjectId +"";
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public String saveList(List<T> lstObj) {
        if(DataUtil.isListNullOrEmpty(lstObj)){
            return Constants.RESULT.FAIL;
        }
        Session session = getSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try {
            int count = 0;

            for(T i: lstObj){
                count++;
                session.save(i);
                if(count == Constants.BASE_BATCH_SIZE){
                    session.flush();
                    session.clear();
                    count = 0;
                }
            }

            tx.commit();

            return Constants.RESULT.SUCCESS;
        } catch (Exception e) {
            log.info(e.toString());
            HibernateUtils.rollback(tx);
            return e.getMessage();
        }finally {
            HibernateUtils.closeConnection(session);
        }
    }

    @Transactional
    public String saveBySession(T obj,Session session) {
        try {
            long id = (long) session.save(obj);
            session.flush();
            return id+"";
        } catch (Exception e) {
            log.error(e.toString());
            return e.getMessage();
        }
    }
    //
    //GET
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getSession().createCriteria(modelClass).list();
    }

    @Transactional(readOnly = true)
    public List<T> getAllByPage(int pageNum, int countPerPage) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(modelClass);
        c.setMaxResults(countPerPage);
        c.setFirstResult(pageNum * countPerPage);
        return c.list();
    }

     @Transactional(readOnly = true)
    public List<T> getList(int count) {
        return getSession().createCriteria(modelClass).setMaxResults(count).list();
//          Query query = sessionFactory.getCurrentSession().getNamedQuery("findAll");
    }

    //find
    @Transactional(readOnly = true)
    public T findById(long id) {
        return getSession().get(modelClass,id);
    }

    @Transactional(readOnly = true)
    public List<T> findByProperty(String property,String value) {
        return getSession().createCriteria(modelClass).add(Restrictions.eq(property,value)).list();
    }




    //TODO test
    @Transactional(readOnly = true)
    public List findAll(Class objectClass) {
        List lstUser = Lists.newArrayList();
        lstUser.add(new User("duyot","password in base dao"));
        return lstUser;
    }


}
