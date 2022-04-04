package com.bookTracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue
    private UUID bookId;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private BookType type;
    @Enumerated(EnumType.STRING)
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
