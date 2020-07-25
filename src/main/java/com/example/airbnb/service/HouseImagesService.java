package com.example.airbnb.service;

import com.example.airbnb.model.House;
import com.example.airbnb.model.HouseImages;

import java.util.Optional;

public interface HouseImagesService {
    Iterable<HouseImages> findAll();

    Optional<HouseImages> findById(Long id);

    void save(HouseImages houseImages);

    void delete(Long id);

    Iterable<HouseImages> findByHouseId(Long id);
}
