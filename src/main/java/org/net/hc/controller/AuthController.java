package org.net.hc.controller;

import org.net.hc.model.User;
import org.net.hc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.net.hc.constants.Constants.*;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return LOGIN;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute(USER, new User());
        return REGISTER;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(Model model, User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute(SUCCESS_MESSAGE, REGISTRATION_SUCCESSFUL);
            model.addAttribute(BINDING_RESULT, bindingResult);
            return REGISTER;
        }
        List<Object> userPresentObj = userService.isUserPresent(user);
        if(Boolean.TRUE.equals(userPresentObj.get(0))){
            model.addAttribute(SUCCESS_MESSAGE, userPresentObj.get(1));
            return REGISTER;
        }

        userService.saveUser(user);
        model.addAttribute(SUCCESS_MESSAGE, REGISTRATION_SUCCESSFUL);

        return LOGIN;
    }
}
