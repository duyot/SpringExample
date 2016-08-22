package com.vivas.springmvc.repo;

import com.vivas.springmvc.model.User;
import com.vivas.springmvc.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyot on 8/22/2016.
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    public List<User> getAllUsers() {
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
}
