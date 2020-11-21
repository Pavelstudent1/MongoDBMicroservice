package org.example.mongo.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String byCause) {
        super("User not found by " + byCause);
    }
}
