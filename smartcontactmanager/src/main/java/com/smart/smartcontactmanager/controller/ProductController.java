package com.smart.smartcontactmanager.controller;

import com.smart.smartcontactmanager.CategoryService;
import com.smart.smartcontactmanager.helper.Message;
import com.smart.smartcontactmanager.models.Category;
import com.smart.smartcontactmanager.models.Product;
import com.smart.smartcontactmanager.models.User;
import com.smart.smartcontactmanager.service.ProductService;
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
public class ProductController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userName = principal.getName();
        //get the user using username(Email)
        System.out.println("USERNAME :" + userName);
        User user = userService.getUserByUserName(userName);
        model.addAttribute("user", user);
        System.out.println("USER " + user);
    }

    @ModelAttribute
    public void addCommonDataPro(Model model, Category category) {
        String categoryName=category.getCategoryName(category);
        //String categoryName = category.getCategoryName();
        System.out.println("categoryname:" + categoryName);
        Category category1 = categoryService.getCategoryByName(categoryName);
        model.addAttribute("categoryName", categoryName);

        model.addAttribute("category", category);
        System.out.println("Category:" + category);
    }

    @GetMapping("user/add-product")
    public String seeAllProductsByCategory(Model model) {
        Category category = new Category();
        model.addAttribute("product", new Product("", category));
        model.addAttribute("category", category);
        return "product/add_product";
    }
 

    @PostMapping("user/process-product")
    public String processContact(@ModelAttribute @RequestBody Product product, Category category, @RequestParam("profileImage") MultipartFile file,
                                 HttpSession session ) {
        String categoryName = category.getCategoryName(category);
        try {
            if (file.isEmpty()) {
                //if the file is empty then try our message
                System.out.println("Files is empty");
            } else {
                //file the file to folder and update the name to contact
                product.setImage(file.getOriginalFilename());
                File saveFile = new ClassPathResource("static/img").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image is uploaded");
            }
            product.setCategory(category);//this both line are important
            // product.getCategory(category);
            //category.getCategoryName();
            category.getProducts(category).add(product);

            productService.addProduct(product);
            categoryService.createCategory(category);
            System.out.println("added to database");
            //mesage success..
            session.setAttribute("message", new Message("Your product is added!! add more", "success"));

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace();
            //message error
            session.setAttribute("message", new Message("something went wrong!! ", "danger"));

        }
        return "product/add_product";


    }



}


