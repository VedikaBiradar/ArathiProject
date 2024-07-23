package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.dto.UserDto;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.User;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/userRegistration")
    public String userRegistration(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "user-registration";
    }

    @PostMapping("/userRegistration/save")
    public String saveRegistration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
        User existing = userService.findUserByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user-registration";
        }

        userService.saveUser(user);
        return "redirect:/userRegistration?success";
    }

    @GetMapping("/registeredUsers")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "registered-users";
    }


}
