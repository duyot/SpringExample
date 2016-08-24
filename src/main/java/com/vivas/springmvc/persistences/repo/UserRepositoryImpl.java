package com.vivas.springmvc.persistences.repo;

import com.vivas.springmvc.persistences.entity.User;
import com.vivas.springmvc.utils.ConnectionManager;
import com.vivas.springmvc.utils.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duyot on 8/22/2016.
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    ConnectionManager connectionManager;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public User findOne(long userId){
        return getCurrentSession().get(User.class,userId);
    }


    public List<User> getAllUsers() {
        printBeans();
        Connection con = connectionManager.getConnectionInSpring();
        List<User> lstUser = new ArrayList<>();
        lstUser.add(new User("duyot","12345"));
        lstUser.add(new User("duyot1","123456"));
        lstUser.add(new User("duyot2","1234567"));
        return lstUser;
    }
    public List<User> getUserByNamNPass(String userame, String password) {
        List<User> lstUser = new ArrayList<>();
        lstUser.add( new User(userame,password));
        return lstUser;
    }

    @Override
    public String registerUser(User user) {
        return Constants.RESULT.SUCCESS;
    }

    public void printBeans() {
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
