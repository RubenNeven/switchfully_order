package com.switchfully.order.service.user;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.exception.NoUserFoundException;
import com.switchfully.order.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserByEmailAddress(String emailAddress) {
        if (userRepository.getUserByEmailAddress(emailAddress).isEmpty()){
            throw new NoUserFoundException("No user with email address: " + emailAddress + " found");
        } else {
            return userRepository.getUserByEmailAddress(emailAddress).get();
        }
    }
}
