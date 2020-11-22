package org.example.hibernate.domain;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Book books;
}
