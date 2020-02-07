package org.example.service;

import org.example.entity.Role;
import org.example.entity.User;
import org.example.exception.UserNotFoundByEmail;
import org.example.exception.UserNotFoundByIdException;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
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
