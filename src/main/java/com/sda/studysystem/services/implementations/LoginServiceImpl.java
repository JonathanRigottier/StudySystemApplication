package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.UserNotFoundException;
import com.sda.studysystem.models.Login;
import com.sda.studysystem.services.LoginService;
import com.sda.studysystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of LoginService
 *
 * @author Vinod John
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public boolean isLoginValid(Login login) {
        try {
            userService.findUserByUserNameAndPassword(login.getUserName(), login.getPassword());
            return true;
        } catch (UserNotFoundException userNotFoundException) {
            return false;
        }
    }
}
