package com.vivas.springmvc.controller;

import com.vivas.springmvc.business.businessinterface.AdminUserBusinessInterface;
import com.vivas.springmvc.business.businessinterface.UserBusinessInterface;
import com.vivas.springmvc.persistences.entity.User;
import com.vivas.springmvc.persistences.repo.UserRepository;
import com.vivas.springmvc.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by duyot on 8/19/2016.
 */
@Controller
@RequestMapping(value = {"/usercp"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBusinessInterface userBusinessInterface;

    @Autowired
    AdminUserBusinessInterface adminUserBusinessInterface;

    //----------------------home--------------------------
    @RequestMapping(method = RequestMethod.GET)
    public String initMainPage(){
        return Constants.VIEW.HOME_SUBS.USER_CP;
    }
    //----------------------sub page-----------------------
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String submitRegister(@Valid User user, Errors errors){
        //
        String result = userRepository.registerUser(user);
        if(errors.hasErrors()){
            System.out.println("Erro in validation"+ errors.getFieldError().toString());
        }
        System.out.println("Register info: " + user.getUsername()+"-"+ user.getPassword());
        System.out.println("Register result: " + result);
        //
        return Constants.VIEW.USER_CP_MAIN.REGISTER_FORM;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(){
        return Constants.VIEW.USER_CP_MAIN.REGISTER_FORM;
    }

    @RequestMapping(value = "/listofuser",method = RequestMethod.GET)
    public String showListOfUser(Model model){
        model.addAttribute("listUser",adminUserBusinessInterface.getAlls());
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }

    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public String getUserByNamNPass(Model model,@RequestParam(value = "username",defaultValue = "duyot") String username, @RequestParam("password") String password){
        model.addAttribute("listUser",userRepository.getUserByNamNPass(username,password));
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }

    @RequestMapping(value = "/finduser/{username}",method = RequestMethod.GET)
    public String getUserById(Model model,@PathVariable String username){
        model.addAttribute("listUser",userRepository.getUserByNamNPass(username,"businessinterface"));
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }
}
