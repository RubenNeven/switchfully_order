package com.switchfully.order.service.user;

import com.switchfully.order.domain.user.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByEmailAddress(String emailAddress);
}
