package com.example.airbnb.service;



import com.example.airbnb.model.CategoryHouse;

import java.util.List;
import java.util.Optional;

public interface CategoryHouseService {
    List<CategoryHouse> findAll();

    Optional<CategoryHouse> findById(Long id);

    void save(CategoryHouse categoryHouse);

}
