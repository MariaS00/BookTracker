package com.bookTracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {

    @Id
    private UUID bookId;
    private String title;
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    private Category category;
    private BookType type;
    private Status bookStatus;

    public Book(String title, List<Author> authors, Category category, BookType type, Status bookStatus) {
        this.bookId = UUID.randomUUID();
        this.title = title;
        this.authors = authors;
        this.category = category;
        this.type = type;
        this.bookStatus = bookStatus;
    }
}
