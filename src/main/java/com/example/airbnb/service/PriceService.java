package com.example.airbnb.service;


import com.example.airbnb.model.Price;

import java.util.Optional;

public interface PriceService {
    Iterable<Price> findAll();

    Optional<Price> findById(Long id);

    void save(Price price);
}
