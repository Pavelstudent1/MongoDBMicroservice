package org.example.mongo.service;

import org.example.mongo.entity.User;

public interface UserService {

    User getById(String id);

    User create(final User user);

    User getByEmail(String email);
}
