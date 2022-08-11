package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle teacher related request
 *
 * @author Rigottier Jonathan
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTeacherById(@PathVariable UUID id) throws TeacherNotFoundException {
            Teacher teacher = teacherService.findTeacherById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setDate(new Date().toInstant());
            return new ResponseEntity<>(teacher, headers, HttpStatus.OK);
        }


    @PostMapping
    public ResponseEntity<?> createTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher) throws TeacherNotFoundException {
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable UUID id) throws TeacherNotFoundException{
            teacherService.deleteTeacherById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreTeacher(@PathVariable UUID id) throws TeacherNotFoundException {
        teacherService.restoreTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

