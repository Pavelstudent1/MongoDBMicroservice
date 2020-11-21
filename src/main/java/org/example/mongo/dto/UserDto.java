package org.example.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mongo.entity.Role;
import org.example.mongo.entity.User;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    public static UserDto from(User user) {
        return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName(), user.getRoles());
    }
}
