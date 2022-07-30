package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle course related request
 *
 * @author Rigottier Jonathan
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String showCourseListPage(Model model, @ModelAttribute("message") String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("courses",courseService.findAllCourses());
        return "course/list-course";
    }

    @GetMapping("/create")
    public String showCreateCoursePage(@ModelAttribute("course") Course course,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType){
        return "course/create-course";
    }

    @PostMapping
    public String createCourse(Course course, RedirectAttributes redirectAttributes) {
        try {
            Course searchCourse = courseService.findCourseByName(course.getName());
            redirectAttributes.addFlashAttribute("message",
                    String.format("Course(%s) already exists!", searchCourse.getName()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/course/create";
        } catch (CourseNotFoundException e) {
            courseService.createCourse(course);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Course(%s) created successfully!", course.getName()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/course";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateCoursePage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes,
                                       @RequestParam(value="course", required = false) Course course) {
        if (course == null) {
            try {
                model.addAttribute("course", courseService.findCourseById(id));
            } catch (CourseNotFoundException e) {
                redirectAttributes.addFlashAttribute("message",
                        String.format("Course(id=%d) not found!", id));
                redirectAttributes.addFlashAttribute("messageType", "error");
                return "redirect:/course";
            }
        }
        return "course/update-course";
    }
    @PostMapping("/update")
    public String updateCourse(Course course, RedirectAttributes redirectAttributes) {
        try {
            courseService.updateCourse(course);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Course(id=%d) created successfully!", course.getId()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/course";
        } catch (CourseNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",
                    String.format("Course(id=%d) not found!", course.getId()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/course";
        }
    }
}
