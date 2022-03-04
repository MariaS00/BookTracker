package com.bookTracker.repositories;

import com.bookTracker.model.Author;
import com.bookTracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    @Override
    List<Author> findAll();

    Optional<Author> getAuthorByAuthorId(UUID authorId);

    Optional<List<Author>> findByName(String name);

    Optional<List<Author>> findBySurname(String surname);

}
