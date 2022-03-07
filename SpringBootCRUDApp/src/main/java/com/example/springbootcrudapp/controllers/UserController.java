package com.example.springbootcrudapp.controllers;

import com.example.springbootcrudapp.model.User;
import com.example.springbootcrudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/users")
    public String getAllUsers (Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users_list";
    }

    @GetMapping("/users/add")
    public String addUserForm (User user) {
        return "add_user";
    }
    @PostMapping ("/add")
    public String addUser (User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser (@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit_user";
    }

    @PatchMapping("/user/{id}")
    public String editUser (User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
