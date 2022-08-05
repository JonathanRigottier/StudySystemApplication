package com.sda.studysystem.exceptions;

import java.util.UUID;

/**
 * Exception for the teacher not found by ID
 *
 * @author Rigottier Jonathan
 */
public class TeacherNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public TeacherNotFoundException(UUID id) {
        super(String.format("Teacher not found for id: %s", id));
    }

    public TeacherNotFoundException(String email) {
        super(String.format("Teacher not found for firstname: %s", email));
    }
}
