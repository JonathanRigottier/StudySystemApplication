package com.sda.studysystem.exceptions;

import java.util.UUID;

/**
 * Exception for the course not found by ID
 *
 * @author Rigottier Jonathan
 */
public class CourseNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public CourseNotFoundException(UUID id) {
        super(String.format("Course not found for id: %s", id));
    }

    public CourseNotFoundException(String name) {
        super(String.format("Course not found for name: %s", name));
    }
}
