package com.bookTracker;

import com.bookTracker.model.*;
import com.bookTracker.repositories.BookRepository;
import com.bookTracker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class BookTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookTrackerApplication.class, args);
    }

    @Component
    @RequiredArgsConstructor
    @Profile("!dev")
    static class InitOnStartup {

        private final BookRepository bookRepository;
        private final BookService bookService;

        @EventListener(ApplicationReadyEvent.class)
        @Transactional
        public void setup() {
            final var joNesbo = new Author("Jo", "Nesbo");
            final var aSapkowski = new Author("Andrzej", "Sapkowski");
            final var dParton = new Author("Dolly", "Parton");
            final var jPatterson = new Author("James", "Patterson");
            final var mick = new Author("Mick", "O'Reilly");

            final var the_kingdom = new Book("The Kingdom", List.of(joNesbo), Category.CRIME, BookType.BOOK, Status.READ);
            final var the_witcher = new Book("The Witcher", List.of(aSapkowski), Category.FANTASY, BookType.AUDIOBOOK, Status.READ);
            final var run_rose_run = new Book("Run Rose run", List.of(dParton, jPatterson), Category.ACTION_AND_ADVENTURE, BookType.BOOK, Status.READING_NOW);
            final var fear_no_evil = new Book("Fear No Evil", List.of(jPatterson), Category.FICTION, BookType.EBOOK, Status.TO_READ);
            final var from_lucifer_to_lazarus = new Book("From Lucifer To Lazarus", List.of(mick), Category.HISTORY, BookType.EBOOK, Status.TO_READ);

            bookRepository.saveAllAndFlush(List.of(the_kingdom, the_witcher, run_rose_run, fear_no_evil, from_lucifer_to_lazarus));
        }
    }
}
