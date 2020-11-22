package org.example.hibernate.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AuthorSequence")
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Authors_Books",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Book> books;
}
