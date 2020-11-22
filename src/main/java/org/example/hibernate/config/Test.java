package org.example.hibernate.config;

import org.example.hibernate.domain.Author;
import org.example.hibernate.domain.Book;
import org.example.hibernate.repository.AuthorRepository;
import org.example.hibernate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Test {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void run() {
        final var book1 = Book.builder().label("Book 1").build();
        final var book2 = Book.builder().label("Book 2").build();
        final var book3 = Book.builder().label("Book 3").build();

        bookRepository.saveAll(Set.of(book1, book2, book3));

        final var author1 = Author.builder().firstName("Pavel").lastName("1").build();
        final var author2 = Author.builder().firstName("Dasha").lastName("2").build();
        final var author3 = Author.builder().firstName("Egor").lastName("3").build();

        authorRepository.saveAll(Set.of(author1, author2, author3));

        System.out.println("=========================");

        author1.setBooks(new HashSet<>(Set.of(book1)));
        author2.setBooks(new HashSet<>(Set.of(book1, book2)));
        author3.setBooks(new HashSet<>(Set.of(book1, book2, book3)));

        authorRepository.saveAll(Set.of(author1, author2, author3));

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
