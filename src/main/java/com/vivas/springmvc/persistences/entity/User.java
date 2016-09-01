package com.vivas.springmvc.persistences.entity;


import com.vivas.springmvc.base.BaseDTO;
import com.vivas.springmvc.base.BaseModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by duyot on 8/22/2016.
 */
public class User extends BaseModel {

    @NotNull
    @Size(min = 5)
    private String username;
    @NotNull
    @Size(min = 5)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public BaseDTO toDTO() {
        return null;
    }
}
