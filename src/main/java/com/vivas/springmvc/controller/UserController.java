package com.vivas.springmvc.controller;

import com.vivas.springmvc.base.BaseBusinessInterface;
import com.vivas.springmvc.business.businessinterface.AdminUserBusinessInterface;
import com.vivas.springmvc.business.businessinterface.UserBusinessInterface;
import com.vivas.springmvc.business.impl.AdminUserBusinessImpl;
import com.vivas.springmvc.dto.AdminUserDTO;
import com.vivas.springmvc.persistences.entity.User;
import com.vivas.springmvc.persistences.repo.UserRepository;
import com.vivas.springmvc.utils.Constants;
import com.vivas.springmvc.utils.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

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
    BaseBusinessInterface adminUserBusiness;

    @Autowired
    AdminUserBusinessInterface adminUserBusinessInterface;

    Logger log = LoggerFactory.getLogger(UserController.class);

    //----------------------home--------------------------
    @RequestMapping(method = RequestMethod.GET)
    public String initMainPage(){
        return Constants.VIEW.HOME_SUBS.USER_CP;
    }
    //----------------------sub page-----------------------
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String submitRegister(AdminUserDTO adminUserDTO, Errors errors){
        //
        adminUserDTO.setStatus("1");
        adminUserDTO.setCreateDate(DateTimeUtils.convertDateToString(new Date()));
        //
        String result = adminUserBusiness.save(adminUserDTO);
//        if(errors.hasErrors()){
//            System.out.println("Erro in validation"+ errors.getFieldError().toString());
//        }
        log.info("Register info: " + adminUserDTO.getUsername()+"-"+ adminUserDTO.getPassword());
        log.info("Register result: " + result);
        if(result == null){
            return Constants.VIEW.ERROR;
        }
        return Constants.VIEW.USER_CP_MAIN.REGISTER_FORM;
        //
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setUsername("duyot");
        adminUserDTO.setPassword("duyot");
        model.addAttribute("adminUserDTO",adminUserDTO);
        return Constants.VIEW.USER_CP_MAIN.REGISTER_FORM;
    }

    @RequestMapping(value = "/listofuser",method = RequestMethod.GET)
    public String showListOfUser(Model model){
        model.addAttribute("listUser",adminUserBusinessInterface.getAdminUserHQL());
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }

    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public String getUserByNamNPass(Model model,@RequestParam("id") String id){
        model.addAttribute("listUser",adminUserBusiness.findById(Long.valueOf(id)));
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }

    @RequestMapping(value = "/finduser/{property}/{value}",method = RequestMethod.GET)
    public String getUserById(Model model,@PathVariable String property,@PathVariable String value){
        model.addAttribute("listUser",adminUserBusiness.findByProperty(property,value));
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }

    @RequestMapping(value = "/finduser/",method = RequestMethod.GET)
    public String test(RedirectAttributes model, @PathVariable String property, @PathVariable String value){
        model.addAttribute("listUser",adminUserBusiness.findByProperty(property,value));
        return Constants.VIEW.USER_CP_MAIN.LIST_OF_USER;
    }
}
