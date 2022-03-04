package com.bookTracker.repositories;

import com.bookTracker.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    Author author1 = new Author("Jo", "Nesbo");
    Author author2 = new Author("Stephen", "King");
    Author author3 = new Author("Joe", "Hill");

    @Test
    @BeforeEach
    void shouldSave() {
        repository.save(author1);
        repository.save(author2);
        repository.save(author3);

        assertEquals(3, repository.count());
    }

    @Test
    void shouldGetAuthorById() {
        final var authorId = author1.getAuthorId();
        final var authorByAuthorId = repository.getAuthorByAuthorId(authorId);

        assertEquals(Optional.of(author1), authorByAuthorId);
    }

    @Test
    void shouldFindByName() {
        final var name = repository.findByName("Jo");

        assertEquals(name, Optional.of(List.of(author1)));
    }

    @Test
    void shouldFindBySurname() {
        final var name = repository.findBySurname("King");

        assertEquals(name, Optional.of(List.of(author2)));
    }
}