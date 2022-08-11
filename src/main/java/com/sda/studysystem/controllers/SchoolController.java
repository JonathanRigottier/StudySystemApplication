package com.sda.studysystem.controllers;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle school related request
 *
 * @author Vinod John
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public List<School> findAllSchools() {
        return schoolService.findAllSchools();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSchoolById(@PathVariable UUID id) throws SchoolNotFoundException {
            School school = schoolService.findSchoolById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setDate(new Date().toInstant());
            return new ResponseEntity<>(school, headers, HttpStatus.OK);
        }

    @PostMapping
    public ResponseEntity<?> createSchool(@Valid @RequestBody School school) {
        schoolService.createSchool(school);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/update")
    public ResponseEntity<?> updateSchool(@RequestBody School school) throws SchoolNotFoundException {
        schoolService.updateSchool(school);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable UUID id) throws SchoolNotFoundException {
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreSchool(@PathVariable UUID id) throws SchoolNotFoundException {
        schoolService.restoreSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}





































