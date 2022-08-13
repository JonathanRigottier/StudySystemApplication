package com.sda.studysystem.exceptions;

/**
 * Exception for user not found
 *
 * @author Vinod John
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String userName) {
        super(String.format("User not found for username=%s ", userName));
    }

    public UserNotFoundException(String userName, String password) {
        super(String.format("User not found for username=%s and the given password", userName));
    }
}
