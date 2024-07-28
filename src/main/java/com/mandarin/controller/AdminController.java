package com.mandarin.controller;


import com.mandarin.entity.User;
import com.mandarin.service.RoleService;
import com.mandarin.service.RoleServiceImp;
import com.mandarin.service.UserService;
import com.mandarin.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserServiceImp userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("alluser", userService.getAll());
        model.addAttribute("userEmail", userService.findByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }



    @PatchMapping("/edit/{id}")
    public String edit(@ModelAttribute("newUser") User user, @RequestParam(value = "listRoles", required = false) ArrayList<Long> roles, @PathVariable("id") long id) {
        if (roles != null) {
            user.setRoles(roleService.findByIdRoles(roles));
        } else {
            user.setRoles(userService.getById(id).getRoles());
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }


    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("newUser") User user,
                             @RequestParam("listRoles") ArrayList<Long> roles){
        user.setRoles(roleService.findByIdRoles(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
