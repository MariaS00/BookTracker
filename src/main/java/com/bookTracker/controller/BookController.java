package com.bookTracker.controller;

import com.bookTracker.model.*;
import com.bookTracker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/addBook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
//        return bookService.create(title, authors, category, type, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book.getTitle(),
                book.getAuthors(),
                book.getCategory(),
                book.getType(),
                book.getBookStatus()));
    }

//    @PostMapping("/addBook")
//    public Book saveBook(String title, List<Author> authors, Category category, BookType type, Status bookStatus) {
//        final var book = bookService.create(title, authors, category, type, bookStatus);
//        return book;
//    }

    @PostMapping("/removeBook")
    public void remove(Book book) {
        bookService.remove(book);
    }

    @GetMapping("/title")
    public Optional<Book> getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/authors/{author}")
    public Optional<List<Book>> getBookByAuthor(@RequestParam(value = "author") Author author) {
        return bookService.getBookByAuthors(author);
    }

    @GetMapping("/categories/{category}")
    public Optional<List<Book>> getBookByCategory(@PathVariable Category category) {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/types/{type}")
    public Optional<List<Book>> getBookByType(@PathVariable BookType type) {
        return bookService.getBookType(type);
    }

    @GetMapping("/statuses/{status}")
    public Optional<List<Book>> getBookByStatus(@RequestParam(value = "status") Status status) {
        return bookService.getBookStatus(status);
    }
}
