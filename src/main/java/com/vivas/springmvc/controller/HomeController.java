package com.vivas.springmvc.controller;

import com.vivas.springmvc.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by duyot on 8/18/2016.
 */
@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {
    //----------------main page--------------------
    @RequestMapping(method = RequestMethod.GET)
    public String initPage(){
        return Constants.VIEW.HOME;
    }

    //----------------sub page ----------------------
    @RequestMapping(value = "/duyot",method = RequestMethod.GET)
    public String initPagePost(){
        return Constants.VIEW.CHILD;
    }
}
