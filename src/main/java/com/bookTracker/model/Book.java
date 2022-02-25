package com.bookTracker.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {

    @Id
    private long id;
    private String title;
    @ManyToMany
    private List<Author> authors;
    private Category category;
    private BookType type;
}
