package com.bookTracker.model;

import com.bookTracker.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthorTest {

    @Autowired
    private AuthorRepository repository;

    @Test
    void shouldSave(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author( "J.K","Rowling,");

        repository.saveAllAndFlush(List.of(author1, author2));

        assertEquals(2, repository.count());

    }
}