package com.sda.studysystem.services;

import com.sda.studysystem.models.Login;

/**
 * Service to handle login related operations
 *
 * @author Vinod John
 */
public interface LoginService {
    /**
     * To check whether the login is valid or not
     *
     * @param login Login
     * @return true or false
     */
    boolean isLoginValid(Login login);
}
