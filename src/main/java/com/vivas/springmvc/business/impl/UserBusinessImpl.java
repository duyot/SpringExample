package com.vivas.springmvc.business.impl;

import com.vivas.springmvc.business.businessinterface.UserBusinessInterface;
import com.vivas.springmvc.persistences.dao.UserDAO;
import com.vivas.springmvc.persistences.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
@Service
public class UserBusinessImpl implements UserBusinessInterface {
    @Autowired
    UserDAO userDAO;

    @Override
    public List getAlls() {
        return userDAO.findAll(User.class);
    }
}
