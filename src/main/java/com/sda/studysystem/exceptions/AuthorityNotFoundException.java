package com.sda.studysystem.exceptions;

/**
 * Exception for authority not found
 *
 * @author Vinod John
 */
public class AuthorityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AuthorityNotFoundException(String name) {
        super(String.format("Authority not found for name : %s", name));
    }

}
