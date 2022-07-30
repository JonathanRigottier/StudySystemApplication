package com.sda.studysystem.exceptions;

/**
 * Exception for the teacher not found by ID
 *
 * @author Rigottier Jonathan
 */
public class TeacherNotFoundException extends Exception{

    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher not found for id: %d", id));
    }

    public TeacherNotFoundException(String name) {
        super(String.format("Teacher not found for name: %s", name));
    }
}
