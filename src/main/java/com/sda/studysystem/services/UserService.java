package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.UserNotFoundException;
import com.sda.studysystem.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle user related operations
 *
 * @author Vinod John
 */

public interface UserService {
    /**
     * To create a new user
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * To find user by userName
     *
     * @param userName userName
     * @return Optional of User
     */
    User findUserByUserName(String userName) throws UserNotFoundException;

    /**
     * To find user by username and password
     *
      * @param userName userName
     * @param password password
     * @return Optional of User
     */
    User findUserByUserNameAndPassword(String userName, String password) throws UserNotFoundException;

    /**
     * To find all users
     *
     * @return
     */
    List<User> findAllUsers();
}
