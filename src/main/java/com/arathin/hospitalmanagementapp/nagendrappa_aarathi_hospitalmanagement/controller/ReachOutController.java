package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.ReachOut;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.ReachOutRepository;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.ReachOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReachOutController {

    private final ReachOutService reachOutService;

    @Autowired
    public ReachOutController(ReachOutService reachOutService) {
        this.reachOutService = reachOutService;
    }


    @GetMapping("/reachOut")
    public String showReachOutForm(Model model) {
        model.addAttribute("reachOut", new ReachOut());
        return "reachOutPage";
    }

    @PostMapping("/reachOut")
    public String submitReachOutForm(@ModelAttribute ReachOut reachOut) {
        reachOutService.saveMessage(reachOut);
        return "redirect:/reachOutPage?success";
    }
}