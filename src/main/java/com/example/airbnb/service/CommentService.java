package com.example.airbnb.service;

import com.example.airbnb.model.CommentForm;
import com.example.airbnb.model.House;

import java.util.Optional;

public interface CommentService {
    Iterable<CommentForm> findAll();

    Optional<CommentForm> findById(Long id);

    void save(CommentForm commentForm);

    void delete(Long id);
}
