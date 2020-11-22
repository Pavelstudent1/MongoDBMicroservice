package org.example.hibernate;

import org.example.hibernate.domain.Author;
import org.example.hibernate.domain.Book;
import org.example.hibernate.repository.AuthorRepository;
import org.example.hibernate.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = HibernateApplication.class)
@Transactional
class HibernateApplicationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void test() {

        final var books = List.of(
                Book.builder().label("Book 1").build(),
                Book.builder().label("Book 2").build(),
                Book.builder().label("Book 3").build()
        );

        final var savedBooks = bookRepository.saveAll(books);
        savedBooks.forEach(System.out::println);

        final var authors = List.of(
                Author.builder().firstName("Pavel").lastName("1").books(savedBooks.get(0)).build(),
                Author.builder().firstName("Dasha").lastName("2").books(savedBooks.get(1)).build(),
                Author.builder().firstName("Egor").lastName("3").books(savedBooks.get(2)).build()
        );

        final var savedAuthors = authorRepository.saveAll(authors);
        savedAuthors.forEach(System.out::println);

        System.out.println("=========================");

        savedBooks.get(0).setAuthors(new HashSet<>(Set.of(savedAuthors.get(0))));
        savedBooks.get(1).setAuthors(new HashSet<>(Set.of(savedAuthors.get(1))));
        savedBooks.get(2).setAuthors(new HashSet<>(Set.of(savedAuthors.get(2))));

        bookRepository.saveAll(savedBooks);

        bookRepository.flush();
        authorRepository.flush();

        System.out.println("=========================");

        final var allBooks = bookRepository.findAll();
        allBooks.forEach(System.out::println);
        final var allAuthors = authorRepository.findAll();
        allAuthors.forEach(System.out::println);

        System.out.println("=========================");
    }
}