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
        final var book = new Book(1, "Son", List.of(new Author(1, "Jo", "Nesbo")), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book(2, "The King", List.of(new Author(1, "Jo", "Nesbo")), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book(3, "Harry Potter", List.of(new Author(2, "J.K","Rowling,")), Category.FANTASY, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        Assertions.assertEquals(3, repository.count());
    }
}