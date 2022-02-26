package com.bookTracker.controller;

import com.bookTracker.model.Book;
import com.bookTracker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book")
    public Book saveBook(Book book){
        return bookService.create(book);
    }

    @PostMapping("/book")
    public void remove(Book book){
         bookService.remove(book);
    }
}
