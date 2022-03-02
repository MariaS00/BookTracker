package com.bookTracker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Author {

    @Id
    private UUID authorId;
    private String name;
    private String surname;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(String name, String surname) {
        this.authorId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
    }
}
