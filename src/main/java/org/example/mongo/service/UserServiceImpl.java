package org.example.mongo.service;

import org.example.mongo.entity.Role;
import org.example.mongo.entity.User;
import org.example.mongo.exception.UserNotFoundByEmail;
import org.example.mongo.exception.UserNotFoundByIdException;
import org.example.mongo.repository.RoleRepository;
import org.example.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundByIdException(id));
    }

    @Override
    public User create(User user) {
        Role defaultRole = roleRepository.findByName("USER");
        user.setRoles(new HashSet<>(Collections.singletonList(defaultRole)));
        return userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElseThrow(() -> new UserNotFoundByEmail(email));
    }

}
