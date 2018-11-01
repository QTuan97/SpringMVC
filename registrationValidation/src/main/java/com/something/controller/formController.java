package com.something.controller;

import com.something.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class formController {
    @GetMapping("/index")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

    @PostMapping("/checkindex")
    public String checkUser(@Validated @Valid @ModelAttribute("user") User user,Model model, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        }else{
            model.addAttribute("user", user);
            return "result";
        }
    }
}
