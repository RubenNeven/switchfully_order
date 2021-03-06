package com.switchfully.order.service.authorisation;

import com.switchfully.order.domain.user.OrderFeature;
import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserRole;
import com.switchfully.order.exception.NoAccessException;
import com.switchfully.order.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.switchfully.order.domain.user.OrderFeature.*;
import static com.switchfully.order.domain.user.UserRole.*;

@Service
public class AuthorisationService {

    private final UserService userService;
    private final Map<OrderFeature, UserRole> authorisationMap;

    public AuthorisationService(UserService userService) {
        this.userService = userService;
        authorisationMap = new HashMap<>();

        // Customer features
        authorisationMap.put(VIEW_ALL_CUSTOMERS, ADMIN);
        authorisationMap.put(VIEW_SINGLE_CUSTOMER, ADMIN);

        // Item features
        authorisationMap.put(ADD_ITEM, ADMIN);
        authorisationMap.put(UPDATE_ITEM, ADMIN);
        authorisationMap.put(GET_ITEMS_BY_STOCK_LEVEL, ADMIN);

    }

    public boolean hasUserAccess(OrderFeature orderFeature, String authorization) {
        if (authorisationMap.get(orderFeature).getAuthorisationLevel() > getAuthorisationLevel(authorization)) {
            throw new NoAccessException("User with email address: " + parseAuthorization(authorization) + " with role " + getUserFromAuthorisation(authorization).getUserRole() + " has no access. Required role is: " + authorisationMap.get(orderFeature));
        }
        return true;
    }

    public int getAuthorisationLevel(String authorization) {
        UserRole userRole = GUEST;
        if (authorization != null) {
            String emailAddressLoggedInUser = parseAuthorization(authorization);
            User userByEmail = userService.getUserByEmailAddress(emailAddressLoggedInUser);
            userRole = userByEmail.getUserRole();
        }
        return userRole.getAuthorisationLevel();
    }


    public String parseAuthorization(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        System.out.println("decoded username & password: " + decodedUsernameAndPassword);
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        return username;
    }

    public User getUserFromAuthorisation(String authorization) {
        String emailAddressLoggedInUser = parseAuthorization(authorization);
        return userService.getUserByEmailAddress(emailAddressLoggedInUser);
    }
}
