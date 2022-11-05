package com.smart.smartcontactmanager.controller;

import com.smart.smartcontactmanager.controller.service.UserService;
import com.smart.smartcontactmanager.models.Contact;
import com.smart.smartcontactmanager.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
      @Autowired
      private UserService userService;



 @RequestMapping("/index")//("/user/index)"url
    public String dashboard(Model model, Principal principal) {
        String userName = principal.getName();
        //get the user using username(Email)
        System.out.println("USERNAME :" + userName);
        User user = userService.getUserByUserName(userName);
       if (user!= null){
            model.addAttribute("user", user);
            System.out.println("YAY");
        }
        else
        {
            model.addAttribute("user", new User());
            System.out.println("Bag of d**ks");
            System.out.println("USER "+user);
        }
        model.addAttribute("user",user);
        System.out.println("USER "+user);
        return "normal/user_dashboard";
  }

    @RequestMapping("/add-contact")
    public String openAddContactForm(Model model){
        model.addAttribute("title","Add_contact ");//to get the title
        model.addAttribute("contact",new Contact());
        return "normal/add_contact_form";
    }
    }


















