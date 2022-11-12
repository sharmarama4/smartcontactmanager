package com.smart.smartcontactmanager.controller;

import com.smart.smartcontactmanager.CategoryService;
import com.smart.smartcontactmanager.helper.Message;
import com.smart.smartcontactmanager.models.Category;

import com.smart.smartcontactmanager.models.User;
import com.smart.smartcontactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userName = principal.getName();
        //get the user using username(Email)
        System.out.println("USERNAME :" + userName);
        User user = userService.getUserByUserName(userName);
        model.addAttribute("user", user);
        System.out.println("USER " + user);
    }

    @GetMapping("user/add-category")
    public String openAddContactForm(Model model) {
        model.addAttribute("title", "Add_category ");//to get the title
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/add_category_form";
    }

    @PostMapping("user/process-category")
    public String processContact(@ModelAttribute Category category,   @RequestParam("profileImage") MultipartFile file,
                                 Principal principal, HttpSession session){
        try{
            if(file.isEmpty()){
                //if the file is empty then try our message
                System.out.println("Files is empty");
            }else{
                //file the file to folder and update the name to contact
                category.setImageUrl(file.getOriginalFilename());
                File saveFile= new ClassPathResource("static/img").getFile();
                Path path= Paths.get(saveFile.getAbsolutePath()+File.separator+ file.getOriginalFilename());
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image is uploaded");

        }
       categoryService.createCategory(category);
            System.out.println("added to database");
            //mesage success..
            session.setAttribute("message",new Message("Your contact is added!! add more","success"));

        }catch (Exception e){
            System.out.println("ERROR "+e.getMessage());
            e.printStackTrace();
            //message error
            session.setAttribute("message",new Message("something went wrong!! ","danger"));

        }
            return "category/add_category_form";
    }

}
