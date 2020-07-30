package com.example.airbnb.service.impl;

import com.example.airbnb.model.Rating;
import com.example.airbnb.repository.OderRepository;
import com.example.airbnb.repository.RatingRepository;
import com.example.airbnb.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Iterable<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Iterable<Rating> findAllByHouseId(Long houseId) {
        return ratingRepository.findAllByHouseId(houseId);
    }
}
