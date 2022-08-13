package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.UserNotFoundException;
import com.sda.studysystem.models.User;
import com.sda.studysystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Customized implementation of UserDetailsService
 *
 * @author Vinod John
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.findUserByUserName(username);
            return new CustomUserDetails(user);
        } catch (UserNotFoundException userNotFoundException) {
            throw new UsernameNotFoundException(userNotFoundException.getLocalizedMessage());
        }
    }
}
