package com.example.airbnb.service;

import com.example.airbnb.model.OrderForm;
import com.example.airbnb.model.Rating;

import java.util.Optional;

public interface RatingService {
    Iterable<Rating> findAll();

    Optional<Rating> findById(Long id);

    void save(Rating rating);

    void delete(Long id);

    Iterable<Rating> findAllByHouseId(Long houseId);
}
