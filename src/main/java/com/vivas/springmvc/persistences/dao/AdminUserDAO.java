package com.vivas.springmvc.persistences.dao;

import com.google.common.collect.Lists;
import com.vivas.springmvc.base.BaseDAOImpl;
import com.vivas.springmvc.dto.AdminUserDTO;
import com.vivas.springmvc.persistences.entity.AdminUser;
import com.vivas.springmvc.utils.DataUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
@Repository
public class AdminUserDAO extends BaseDAOImpl<AdminUser,Long> {

//    public List<AdminUser> getAdminUserHQL(){
//        Query query = getSession().createQuery("from AdminUser au where au.id = :id order by au.createDate");
//        query.setComment("This is comment in query");
//        query.setLong("id",1L);
//        query.uniqueResult();
//        return query.list();
//    }
    @Transactional
    public List<AdminUser> getAdminUserHQL(){
        SQLQuery query = null;
        try {
            query = getSession().createSQLQuery("select {admin_user.*} from ADMIN_USER admin_user where admin_user.status = :status");
            query.setParameter("status","1");
//            query.setResultTransformer(Transformers.aliasToBean(AdminUser.class));
            query.addEntity("admin_user",AdminUser.class);
//            query.addScalar("userId",new LongType());
//            query.addScalar("username",new StringType());
//            query.addScalar("password",new StringType());
//            query.addScalar("status",new StringType());
//            query.addScalar("createDate",new DateType());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    public static void main(String[] args) {
    }
}
