package com.sda.studysystem.exceptions;

/**
 * Exception for school already exists by name
 *
 * @author Vinod John
 */
public class SchoolAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    public SchoolAlreadyExistsException(String name) {
        super(String.format("School(name=%s) already exists! Cannot create the same school! ", name));
    }
}
