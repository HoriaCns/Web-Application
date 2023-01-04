package org.net.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.net.hc.constants.Constants.ADMIN_DASHBOARD;

@Controller
public class AdminController {
    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return ADMIN_DASHBOARD;
    }
}
