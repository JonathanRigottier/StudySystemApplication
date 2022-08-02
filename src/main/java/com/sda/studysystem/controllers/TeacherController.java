package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * Controller to handle teacher related request
 *
 * @author Rigottier Jonathan
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String showTeacherListPage(Model model, @ModelAttribute("message") String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("teachers",teacherService.findAllTeachers());
        return "teacher/list-teacher";
    }

    @GetMapping("/{id}")
    public String showTeacherViewPage(@PathVariable Long id ,Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("teacher", teacherService.findTeacherById(id));
            return "teacher/view-teacher";
        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(id, redirectAttributes);
        }
    }

    @GetMapping("/create")
    public String showCreateTeacherPage(@ModelAttribute("teacher") Teacher teacher,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType){
        return "teacher/create-teacher";
    }

    @PostMapping
    public String createTeacher(Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            Teacher searchTeacher = teacherService.findTeacherByEmail(teacher.getEmail());
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(%s) already exists!", searchTeacher.getEmail()));
            redirectAttributes.addFlashAttribute("messageType","error");
            return "redirect:/teacher/create";
        } catch (TeacherNotFoundException e) {
            teacherService.createTeacher(teacher);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(%s) created successfully!", teacher.getEmail()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/teacher";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes,
                                       @RequestParam(value="teacher", required = false) Teacher teacher) {
        if (teacher == null) {
            try {
                model.addAttribute("teacher", teacherService.findTeacherById(id));
            } catch (TeacherNotFoundException e) {
                return handleTeacherNotFoundExceptionById(id, redirectAttributes);
            }
        }
        return "teacher/update-teacher";
    }
    @PostMapping("/update")
    public String updateTeacher(Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            teacherService.updateTeacher(teacher);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(id=%d) created successfully!", teacher.getId()));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/teacher";
        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(teacher.getId(), redirectAttributes);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            teacherService.deleteTeacherById(id);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(id=%d) deleted successfully!", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/teacher";

        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(id, redirectAttributes);
        }
    }

    @GetMapping("/restore/{id}")
    public String restoreTeacher(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            teacherService.restoreTeacherById(id);
            redirectAttributes.addFlashAttribute("message",
                    String.format("Teacher(id=%d) restored successfully!", id));
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/teacher";

        } catch (TeacherNotFoundException e) {
            return handleTeacherNotFoundExceptionById(id, redirectAttributes);
        }
    }

    // PRIVATE METHODS //
    private String handleTeacherNotFoundExceptionById(long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message",
                String.format("Teacher(id=%d) not found!", id));
        redirectAttributes.addFlashAttribute("messageType", "error");
        return "redirect:/teacher";
    }

}
