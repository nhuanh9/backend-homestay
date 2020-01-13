package com.example.airbnb.service;

import com.example.airbnb.model.OderForm;

import java.util.Optional;

public interface OderService {
    Iterable<OderForm>findAll();
    Optional<OderForm>findById(Long id);
    void save(OderForm oderForm);
    void delete(Long id);
}
