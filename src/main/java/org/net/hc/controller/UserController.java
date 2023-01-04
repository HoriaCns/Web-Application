package org.net.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.net.hc.constants.Constants.USER_DASHBOARD;

@Controller
public class UserController {
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String homePage(){
        return USER_DASHBOARD;
    }
}
