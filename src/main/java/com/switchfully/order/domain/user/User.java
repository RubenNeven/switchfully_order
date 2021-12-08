package com.switchfully.order.domain.user;

public class User {
    private final String emailAddress;
    private final UserRole userRole;

    public User(String emailAddress, UserRole userRole) {
        this.emailAddress = emailAddress;
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
