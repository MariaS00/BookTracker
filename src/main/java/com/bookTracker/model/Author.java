package com.bookTracker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Author {

    @Id
    private long authorId;
    private String name;
    private String surname;

}
