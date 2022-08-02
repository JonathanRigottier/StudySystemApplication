package com.sda.studysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle home page related requests
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("message","Hello, Jonathan Rigottier !");

        return "home";
    }
}
