package com.bookTracker.repositories;

import com.bookTracker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

    Optional<Book> findById(Long bookId);

    Optional<Book> getBookByTitle(String title);

    Optional<List<Book>> getBooksByAuthors(Author author);

    Optional<List<Book>> getBooksByCategory(Category category);

    Optional<List<Book>> getBooksByType(BookType type);

    List<Book> getBooksByBookStatus(Status status);

}
