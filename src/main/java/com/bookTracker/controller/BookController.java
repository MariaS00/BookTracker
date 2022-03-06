package com.bookTracker.controller;

import com.bookTracker.model.*;
import com.bookTracker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/addBook")
    public Book saveBook(Book book) {
        return bookService.create(book);
    }

    @PostMapping("/removeBook")
    public void remove(Book book) {
        bookService.remove(book);
    }

    @GetMapping("/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/{author}")
    public Optional<List<Book>> getBookByAuthor(@PathVariable Author author) {
        return bookService.getBookByAuthors(author);
    }

    @GetMapping("/{category}")
    public Optional<List<Book>> getBookByCategory(@PathVariable Category category) {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/{type}")
    public Optional<List<Book>> getBookByType(@PathVariable BookType type) {
        return bookService.getBookType(type);
    }

    @GetMapping("/{status}")
    public Optional<List<Book>> getBookByStatus(@PathVariable Status status) {
        return bookService.getBookStatus(status);
    }
}
