package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.UserNotFoundException;
import com.sda.studysystem.models.User;
import com.sda.studysystem.repositories.UserRepository;
import com.sda.studysystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserService
 *
 * @author Vinod John
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(userName);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(userName);
        }
        return optionalUser.get();
    }

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword (userName, password);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(userName, password);
        }
        return optionalUser.get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
