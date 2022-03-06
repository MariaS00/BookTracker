package com.bookTracker.service;

import com.bookTracker.model.*;
import com.bookTracker.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void remove(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    public Optional<List<Book>> getBookByAuthors(Author author) {
        return bookRepository.getBooksByAuthors(author);
    }

    public Optional<List<Book>> getBooksByCategory(Category category) {
        return bookRepository.getBooksByCategory(category);
    }

    public Optional<List<Book>> getBookType(BookType type) {
        return bookRepository.getBooksByType(type);
    }

    public Optional<List<Book>> getBookStatus(Status status) {
        return bookRepository.getBooksByBookStatus(status);
    }
}
