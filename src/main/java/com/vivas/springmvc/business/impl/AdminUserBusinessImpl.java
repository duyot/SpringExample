package com.vivas.springmvc.business.impl;

import com.google.common.collect.Lists;
import com.vivas.springmvc.business.businessinterface.AdminUserBusinessInterface;
import com.vivas.springmvc.persistences.dao.AdminUserDAO;
import com.vivas.springmvc.persistences.dao.UserDAO;
import com.vivas.springmvc.persistences.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
@Service
public class AdminUserBusinessImpl implements AdminUserBusinessInterface {
    @Autowired
    AdminUserDAO adminUserDAO;


    @Override
    public List getAlls() {
        List<AdminUser> lst = Lists.newArrayList();
        lst.add(adminUserDAO.findById(11L,AdminUser.class));
        return lst;
    }
}
