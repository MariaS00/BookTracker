package com.bookTracker.controller;

import com.bookTracker.model.Author;
import com.bookTracker.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    @GetMapping("/all")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{name}")
    public Optional<List<Author>> getAuthorByName(@PathVariable String name) {
        return authorService.findByName(name);
    }

    @GetMapping("/{surname}")
    public Optional<List<Author>> getAuthorBySurname(@PathVariable String surname) {
        return authorService.findBySurname(surname);
    }
}
