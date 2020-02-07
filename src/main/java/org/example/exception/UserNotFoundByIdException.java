package org.example.exception;

public class UserNotFoundByIdException extends UserNotFound {
    public UserNotFoundByIdException(String id) {
        super("id: " + id);
    }
}
