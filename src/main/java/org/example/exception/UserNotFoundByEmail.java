package org.example.exception;

public class UserNotFoundByEmail extends UserNotFound {
    public UserNotFoundByEmail(String email) {
        super("email: " + email);
    }
}
