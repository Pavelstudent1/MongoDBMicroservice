package org.example.service;

import org.example.entity.User;

public interface UserService {

    User getById(String id);

    User create(final User user);

    User getByEmail(String email);
}
