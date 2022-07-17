package com.sda.studysystem.exceptions;

/**
 * Exception for the school not found by ID
 *
 * @author Vinod John
 */
public class SchoolNotFoundException extends Exception {
    public SchoolNotFoundException(Long id) {
        super(String.format("School not found for id: %d", id));
    }
}
