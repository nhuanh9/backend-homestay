package com.example.airbnb.controller;

import com.example.airbnb.model.HouseImages;
import com.example.airbnb.model.OrderForm;
import com.example.airbnb.model.Rating;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.HouseService;
import com.example.airbnb.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/rate")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private HouseService houseService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        ratingService.save(rating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-rates-of-house/{house-id}")
    public ResponseEntity<Iterable<Rating>> findImagesByHouseName(@PathVariable("house-id") Long houseId) {
        Iterable<Rating> ratings = ratingService.findAllByHouseId(houseId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);

    }
}
