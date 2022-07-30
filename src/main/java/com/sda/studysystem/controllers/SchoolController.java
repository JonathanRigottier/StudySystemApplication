package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle school related request
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String showSchoolListPage(Model model, @ModelAttribute("message") String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("schools",schoolService.findAllSchools());
        return "school/list-school";
    }

    @GetMapping("/create")
    public String showCreateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType){
        return "school/create-school";
    }

    @PostMapping
    public String createSchool(School school, RedirectAttributes redirectAttributes) {
        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(%s) already exists!", searchSchool.getName()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/school/create";
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(%s) created successfully!", school.getName()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/school";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateSchoolPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes,
                                       @RequestParam(value="school", required = false) School school) {
        if (school == null) {
            try {
                model.addAttribute("school", schoolService.findSchoolById(id));
            } catch (SchoolNotFoundException e) {
                redirectAttributes.addFlashAttribute("message",
                        String.format("School(id=%d) not found!", id));
                redirectAttributes.addFlashAttribute("messageType", "error");
                return "redirect:/school";
            }
        }
        return "school/update-school";
    }
    @PostMapping("/update")
    public String updateSchool(School school, RedirectAttributes redirectAttributes) {
        try {
            schoolService.updateSchool(school);
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(id=%d) created successfully!", school.getId()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/school";
        } catch (SchoolNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(id=%d) not found!", school.getId()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/school";
        }
    }
}
