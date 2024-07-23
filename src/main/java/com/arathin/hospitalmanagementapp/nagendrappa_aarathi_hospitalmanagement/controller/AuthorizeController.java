package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller;

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
import java.util.Optional;


@Controller
public class AuthorizeController {


    private UserService userService;

    @Autowired
    public AuthorizeController(UserService userService) {
        this.userService = userService;
    }

    //access the login page
    @GetMapping("/login")
    public String loginForm()
    {
        return "login";
    }


    // Admin Dashboard
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
        return "adminDashboard";
    }

    //Parent dashboard
    @GetMapping("/parentDashboard")
    public String userDashboard() {
        return "patientDashboard";
    }


}








