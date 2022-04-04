package com.bookTracker.repositories;

import com.bookTracker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findAll();

    Optional<Book> findBookByBookId(UUID bookId);

    Optional<Book> getBookByTitle(String title);

    Optional<List<Book>> getBooksByAuthors(Author author);

    Optional<List<Book>> getBooksByCategory(Category category);

    Optional<List<Book>> getBooksByType(BookType type);

    Optional<List<Book>> getBooksByBookStatus(Status status);

    int countBooksByAuthorsOrderByAuthorsAsc(Author author);

    int countBooksByBookStatus(Status status);
}
