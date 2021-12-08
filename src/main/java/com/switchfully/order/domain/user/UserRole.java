package com.switchfully.order.domain.user;

public enum UserRole {
    ADMIN(99),
    STAFF(1),
    GUEST(0);

    private final int authorisationLevel;

    UserRole(int authorisationLevel) {
        this.authorisationLevel = authorisationLevel;
    }

    public int getAuthorisationLevel() {
        return authorisationLevel;
    }
}
