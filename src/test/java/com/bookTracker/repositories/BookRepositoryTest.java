package com.bookTracker.repositories;

import com.bookTracker.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSave() {
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        assertEquals(3, repository.count());
    }

    @Test
    void shouldFindBookById(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var bookId = book.getBookId();
        final var bookByBookId = repository.findBookByBookId(bookId);

        assertEquals(Optional.of(book), bookByBookId);
    }

    @Test
    void shouldFindBookByTitle(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var bookByTitle = repository.getBookByTitle("Desperation");

        assertEquals(Optional.of(audiobook), bookByTitle);
    }

    @Test
    void shouldFindBooksByAuthors(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var booksByAuthors = repository.getBooksByAuthors(author2);

        final var list = Optional.of(List.of(ebook, audiobook));
        assertEquals(list.stream().count(), booksByAuthors.stream().count());
    }

    @Test
    void shouldFindBooksByCategory(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var booksByCategory = repository.getBooksByCategory(Category.CRIME);

        final var list = Optional.of(List.of(ebook, book));
        assertEquals(list.stream().count(), booksByCategory.stream().count());
    }

    @Test
    void shouldFindBooksByType(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var booksByType = repository.getBooksByType(BookType.AUDIOBOOK);

        assertEquals(Optional.of(List.of(audiobook)), booksByType);
    }

    @Test
    void shouldFindBooksByStatus(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var booksByBookStatus = repository.getBooksByBookStatus(Status.TO_READ);

        assertEquals(Optional.of(List.of(ebook)), booksByBookStatus);
    }

    @Test
    void shouldCountBooksByAuthors(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var books = repository.countBooksByAuthorsOrderByAuthorsAsc(author2);

        assertEquals(2, books);
    }

    @Test
    void shouldCountBooksByStatus(){
        final var author1 = new Author("Jo", "Nesbo");
        final var author2 = new Author("Stephen", "King");
        final var author3 = new Author("Joe", "Hill");

        final var book = new Book("Son", List.of(author1), Category.CRIME, BookType.BOOK, Status.READ);
        final var ebook = new Book("In the Tall Grass", List.of(author2, author3), Category.CRIME, BookType.EBOOK, Status.TO_READ);
        final var audiobook = new Book("Desperation", List.of(author2), Category.HORROR, BookType.AUDIOBOOK, Status.READING_NOW);

        repository.saveAllAndFlush(List.of(book, ebook, audiobook));

        final var books = repository.countBooksByBookStatus(Status.READING_NOW);

        assertEquals(1, books);
    }
}