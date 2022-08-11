package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.CourseService;
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
 * Controller to handle course related request
 *
 * @author Rigottier Jonathan
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable UUID id) throws CourseNotFoundException {
        Course course = courseService.findCourseById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setDate(new Date().toInstant());
            return new ResponseEntity<>(course, headers, HttpStatus.OK);
        }

    @PostMapping
    public ResponseEntity<?> createCourse(@Valid @RequestBody Course course) {
            courseService.createCourse(course);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

   @PostMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) throws CourseNotFoundException {
           courseService.updateCourse(course);
          return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable UUID id) throws CourseNotFoundException {
            courseService.deleteCourseById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCourse (@PathVariable UUID id) throws CourseNotFoundException {
            courseService.restoreCourseById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
