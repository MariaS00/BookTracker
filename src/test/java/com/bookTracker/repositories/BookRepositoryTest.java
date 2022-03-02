package com.bookTracker.repositories;

import com.bookTracker.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private EntityManager entityManager;

    List<Author> a = new ArrayList<>();

    @Test
    void shouldSave(){
        final var book = new Book( "Son", List.of(new Author( "Jo", "Nesbo")), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book( "The King", List.of(new Author( "Jo", "Nesbo")), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book( "Harry Potter", List.of(new Author( "J.K","Rowling,")), Category.FANTASY, BookType.AUDIOBOOK, Status.READING_NOW);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(ebook);
        books.add(audiobook);
        repository.saveAllAndFlush(books);

        Assertions.assertEquals(3, repository.count());
    }
}