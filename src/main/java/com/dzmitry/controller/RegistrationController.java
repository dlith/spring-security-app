package com.dzmitry.controller;

import com.dzmitry.entity.User;
import com.dzmitry.service.UserService;
import com.dzmitry.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model){
        model.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "registration-form";
        }

        User existing = userService.findByName(crmUser.getUserName());
        if(existing !=null){
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name is already exists");
            return "registration-form";
        }

        userService.save(crmUser);

        return "registration-confirmation";
    }
}
