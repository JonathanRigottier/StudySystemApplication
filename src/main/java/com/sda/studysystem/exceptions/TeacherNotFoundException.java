package com.sda.studysystem.exceptions;

/**
 * Exception for the teacher not found by ID
 *
 * @author Rigottier Jonathan
 */
public class TeacherNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher not found for id: %d", id));
    }

    public TeacherNotFoundException(String email) {
        super(String.format("Teacher not found for firstname: %s", email));
    }
}
