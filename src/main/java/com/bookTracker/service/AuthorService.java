package com.bookTracker.service;

import com.bookTracker.model.Author;
import com.bookTracker.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public Author create(Author author){
        return authorRepository.save(author);
    }

    public void remove(Author author){
         authorRepository.delete(author);
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(UUID id){
        return authorRepository.getAuthorByAuthorId(id);
    }

    public Optional<List<Author>> findByName(String name){
        return authorRepository.findByName(name);
    }

    public Optional<List<Author>> findBySurname(String surname){
        return authorRepository.findBySurname(surname);
    }
}
