package com.switchfully.order.repository.user;

import com.switchfully.order.domain.user.OrderFeature;
import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.order.domain.user.UserRole.*;

@Repository
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    void populate(){
        users.add(new User("rubenneven@gmail.com", ADMIN));
        users.add(new User("miadomen@gmail.com", STAFF));
        users.add(new User("sofieverryssen@gmail.com", GUEST));
    }
}
