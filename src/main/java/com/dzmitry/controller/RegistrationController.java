package com.dzmitry.controller;

import com.dzmitry.user.CrmUser;
import jdk.internal.module.IllegalAccessLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model){
        model.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }
}
