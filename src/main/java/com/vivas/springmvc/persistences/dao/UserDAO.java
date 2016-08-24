package com.vivas.springmvc.persistences.dao;

import com.vivas.springmvc.base.BaseDAOImpl;
import com.vivas.springmvc.persistences.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by duyot on 8/24/2016.
 */
@Repository
public class UserDAO extends BaseDAOImpl<User> {


    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
    }

}
