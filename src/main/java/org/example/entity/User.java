package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    private String id;

    @Indexed(name = "email_index", unique = true, direction = IndexDirection.ASCENDING)
    private String email;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("enabled")
    private boolean enabled;

    public static User from(UserDto userDto) {
        return new User(null, userDto.getEmail(), userDto.getFirstName(), userDto.getLastName(), false);
    }
}
