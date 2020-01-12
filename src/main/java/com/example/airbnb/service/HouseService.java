package com.example.airbnb.service;


import com.example.airbnb.model.House;

import java.util.Optional;

public interface HouseService {
    Iterable<House> findAll();

    Optional<House> findById(Long id);

    void save(House house);

    void delete(Long id);
    
}
