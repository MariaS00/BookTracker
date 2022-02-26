package com.bookTracker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private Status bookStatus;
}
