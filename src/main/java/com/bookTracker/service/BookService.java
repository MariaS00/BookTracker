package com.bookTracker.service;

import com.bookTracker.model.Book;
import com.bookTracker.model.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public Book create(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }


}
