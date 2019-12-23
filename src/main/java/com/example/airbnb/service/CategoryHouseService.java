package com.example.airbnb.service;


import com.example.airbnb.model.CategoryHouse;

import java.util.Optional;

public interface CategoryHouseService {
    Iterable<CategoryHouse> findAll();

    Optional<CategoryHouse> findById(Long id);

    void save(CategoryHouse categoryHome);

    Optional<CategoryHouse> findByName(String name);
}
