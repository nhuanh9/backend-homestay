package com.example.airbnb.service;



import com.example.airbnb.model.Price;

import java.util.List;
import java.util.Optional;

public interface PriceService {
    List<Price> findAll();

    Optional<Price> findById(Long id);

    void save(Price price);
}
