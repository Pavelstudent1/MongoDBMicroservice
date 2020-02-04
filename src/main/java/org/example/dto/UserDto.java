package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;

    public static UserDto from(User user) {
        return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName());
    }
}
