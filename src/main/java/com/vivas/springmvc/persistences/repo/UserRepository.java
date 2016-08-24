package com.vivas.springmvc.persistences.repo;

import com.vivas.springmvc.persistences.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by duyot on 8/19/2016.
 */
@Repository
public interface UserRepository {
    List<User> getAllUsers();
    List<User> getUserByNamNPass(String userame, String password);
    String registerUser(User user);
}
