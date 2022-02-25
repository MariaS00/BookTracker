package com.bookTracker.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Author {

    @Id
    private long authorId;
    private String name;
    private String surname;

}
