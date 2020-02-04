package org.example.controller;

import org.example.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class Endpoint {

    @GetMapping("/test")
    public UserDto testGet() {
        return new UserDto(1L, "user.test@email.com", "Name", "Last");
    }
}
