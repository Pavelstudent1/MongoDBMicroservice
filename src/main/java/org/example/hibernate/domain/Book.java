package org.example.hibernate.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BookSequence")
    private Long id;

    private String label;

    @OneToMany(mappedBy = "books", cascade = {CascadeType.ALL})
    private Set<Author> authors = new HashSet<>();
}
