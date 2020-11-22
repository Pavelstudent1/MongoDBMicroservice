package org.example.hibernate;

import org.example.hibernate.domain.Book;
import org.example.hibernate.repository.AuthorRepository;
import org.example.hibernate.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HibernateApplication.class)
class HibernateApplicationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void test() {
        final Book book = Book.builder().label("White Fang").build();
        System.out.println(book);
        final Book saved = bookRepository.save(book);
        System.out.println(saved);
    }
}