package com.vivas.springmvc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by duyot on 8/22/2016.
 */
public class User {

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
}
